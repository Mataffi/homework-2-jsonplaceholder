package mataffi;

import jakarta.persistence.EntityNotFoundException;
import mataffi.entity.User;
import mataffi.repository.UserRepository;
import mataffi.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");
        user1.setUsername("alice");
        user1.setEmail("alice@example.com");

        user2 = new User();
        user2.setId(2L);
        user2.setName("Bob");
        user2.setUsername("bob");
        user2.setEmail("bob@example.com");
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserByIdFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals("Alice", foundUser.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(3L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(EntityNotFoundException.class, () ->
                userService.getUserById(3L));
        assertEquals("User not found with id: 3", exception.getMessage());
        verify(userRepository, times(1)).findById(3L);
    }
}
