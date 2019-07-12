package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JobRequest {

    private String name;
    private Double pricePerWord;
    private String description;
    private Long volume;
    private Date deadline;
    private String sourceLanguage;
    private String targetLanguage;
    private Long categoryId;

}
