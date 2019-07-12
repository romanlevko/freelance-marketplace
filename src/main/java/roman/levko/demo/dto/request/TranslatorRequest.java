package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class TranslatorRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @Size(min = 6, max = 30)
    private String password;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotEmpty
    private Double ranking;
    @NotEmpty
    private List<Long> jobs;
}
