package mataffi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "geo")
@Data
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lat;
    private String lng;
}
