package mataffi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "auth_users")
@Data
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String passwordHash; // Store hashed password
}
