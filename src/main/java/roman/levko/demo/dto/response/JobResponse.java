package roman.levko.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.levko.demo.entity.Job;

import java.util.Date;

@Getter
@Setter
public class JobResponse {

    private Long id;
    private String name;
    private Double pricePerWord;
    private String description;
    private Long volume;
    private Date deadline;
    private String sourceLanguage;
    private String targetLanguage;
    private CategoryResponse category;

    public JobResponse (Job job) {
        id = job.getId();
        name = job.getName();
        description = job.getDescription();
        pricePerWord = job.getPricePerWord();
        volume = job.getVolume();
        deadline = job.getDeadline();
        sourceLanguage = job.getSourceLanguage();
        targetLanguage = job.getTargetLanguage();
        category = new CategoryResponse(job.getCategory());
    }
}
