package mataffi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
class CompanyDto {
    @NotBlank
    private String name;
    @NotBlank
    private String catchPhrase;
    @NotBlank
    private String bs;
}
