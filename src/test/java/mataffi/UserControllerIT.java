package mataffi;

import mataffi.dto.AuthRequest;
import mataffi.dto.AuthResponse;
import mataffi.dto.UserDto;
import mataffi.entity.AuthUser;
import mataffi.repository.AuthUserRepository;
import mataffi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class UserControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13-alpine")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpassword");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop"); // For test specific schema creation
        registry.add("spring.flyway.enabled", () -> "false"); // Disable Flyway for test containers, let JPA manage schema
    }

    private String adminToken;

    @BeforeEach
    void setUp() {
        // Clear repositories before each test
        userRepository.deleteAll();
        authUserRepository.deleteAll();

        // Register a test admin user and get JWT token
        AuthUser adminUser = new AuthUser();
        adminUser.setEmail("admin@example.com");
        adminUser.setPasswordHash(passwordEncoder.encode("adminpass"));
        authUserRepository.save(adminUser);

        AuthRequest authRequest = AuthRequest.builder()
                .email("admin@example.com")
                .password("adminpass")
                .build();
        ResponseEntity<AuthResponse> loginResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/auth/login", authRequest, AuthResponse.class);
        adminToken = loginResponse.getBody().getJwt();
    }

    @Test
    void testCreateUserAuthenticated() {
        UserDto newUserDto = new UserDto();
        newUserDto.setName("Test User");
        newUserDto.setUsername("testuser");
        newUserDto.setEmail("test@example.com");

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(adminToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> request = new HttpEntity<>(newUserDto, headers);

        ResponseEntity<UserDto> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/users", request, UserDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getName()).isEqualTo("Test User");
    }

    @Test
    void testGetAllUsersUnauthenticated() {
        ResponseEntity<UserDto[]> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/users", UserDto[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
