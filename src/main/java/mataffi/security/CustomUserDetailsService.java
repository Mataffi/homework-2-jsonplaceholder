package mataffi.security;

import mataffi.entity.AuthUser;
import mataffi.repository.AuthUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public CustomUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Map AuthUser to Spring Security UserDetails.
        // For simplicity, assigning "USER" role. You can extend this with role management.
        return new org.springframework.security.core.userdetails.User(
                authUser.getEmail(),
                authUser.getPasswordHash(),
                new ArrayList<>() // Empty list for authorities/roles for now
        );
    }
}