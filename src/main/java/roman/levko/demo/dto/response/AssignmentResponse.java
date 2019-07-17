package roman.levko.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.levko.demo.entity.Assignment;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AssignmentResponse {

    private LocalDate date;
    private LocalTime time;

    //    private JobResponse job;
    private ClientResponse client;
    private TranslatorResponse translator;

    public AssignmentResponse(Assignment assignment) {

        date = assignment.getDate();
        time = assignment.getTime();

//        job = new JobResponse(assignment.getJob());
        client = new ClientResponse(assignment.getClient());
        translator = new TranslatorResponse(assignment.getTranslator());

    }
}
