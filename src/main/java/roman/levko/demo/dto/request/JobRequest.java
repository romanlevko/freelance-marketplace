package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class JobRequest {
    @NotBlank
    private String name;
    @NotNull
    private Double pricePerWord;

    private String description;
    @NotNull
    private Long volume;
    private Date deadline;
    @NotBlank
    private String sourceLanguage;
    @NotBlank
    private String targetLanguage;
    @NotNull
    private Long categoryId;

}
