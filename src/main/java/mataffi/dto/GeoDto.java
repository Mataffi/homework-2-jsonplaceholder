package mataffi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
class GeoDto {
    @NotBlank
    private String lat;
    @NotBlank
    private String lng;
}
