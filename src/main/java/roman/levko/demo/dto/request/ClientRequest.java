package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class ClientRequest {
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
    @NotNull
    private Double ranking;

    private String image;
    private List<Long> jobs;
    private List<Long> categories;

}
