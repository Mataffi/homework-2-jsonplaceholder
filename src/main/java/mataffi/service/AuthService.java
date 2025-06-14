package mataffi.service;

import lombok.RequiredArgsConstructor;
import mataffi.dto.AuthRequest;
import mataffi.dto.AuthResponse;
import mataffi.entity.AuthUser;
import mataffi.repository.AuthUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthResponse register(AuthRequest request) {
        if (authUserRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered"); // Or custom exception
        }
        AuthUser authUser = new AuthUser();
        authUser.setEmail(request.getEmail());
        authUser.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        authUserRepository.save(authUser);

        UserDetails userDetails = userDetailsService.loadUserByUsername(authUser.getEmail());
        String jwtToken = jwtService.generateToken(userDetails);
        return new AuthResponse(jwtToken);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        // If authentication succeeds, generate token
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String jwtToken = jwtService.generateToken(userDetails);
        return new AuthResponse(jwtToken);
    }
}
