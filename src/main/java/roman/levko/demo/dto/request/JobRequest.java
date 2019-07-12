package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class JobRequest {
    @NotNull
    private String name;
    private Double pricePerWord;
    private String description;
    private Long volume;
    private Date deadline;
    private String sourceLanguage;
    private String targetLanguage;
    private Long categoryId;

}
