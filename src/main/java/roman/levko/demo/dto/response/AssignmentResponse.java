package roman.levko.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.levko.demo.entity.Assignment;

@Getter
@Setter
public class AssignmentResponse {

    private JobResponse job;
    private ClientResponse client;
    private TranslatorResponse translator;

    public AssignmentResponse (Assignment assignment) {

        job = new JobResponse(assignment.getJob());
        client = new ClientResponse(assignment.getClient());
        translator = new TranslatorResponse(assignment.getTranslator());

    }
}
