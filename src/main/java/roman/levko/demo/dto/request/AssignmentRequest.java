package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AssignmentRequest {

//    @NotNull
//    private Long jobId;

    @NotNull
    private Long clientId;

    @NotNull
    private Long translatorId;

}
