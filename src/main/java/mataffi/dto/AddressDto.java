package mataffi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
class AddressDto {
    @NotBlank
    private String street;
    @NotBlank private String suite;
    @NotBlank private String city;
    @NotBlank private String zipcode;
    @Valid
    private GeoDto geo;
}
