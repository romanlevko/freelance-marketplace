package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class TranslatorRequest {
    @NotBlank
    private String username;
    @Size(min = 6, max = 30)
    private String password;
    @NotBlank
    private String FirstName;
    @NotBlank
    private String SecondName;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotNull
    private Long age;
    @NotNull
    private Long yearsOfExperience;
    @NotNull
    private Double ranking;
    @NotEmpty
    private List<Long> categories;

    private String image;
}
