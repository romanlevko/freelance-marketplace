package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AssignmentRequest {

    @NotEmpty
    private LocalDate date;
    @NotEmpty
    private LocalTime time;

    @NotNull
    private Long clientId;

    @NotNull
    private Long translatorId;

}
