package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.AssignmentRequest;
import roman.levko.demo.dto.request.CategoryRequest;
import roman.levko.demo.dto.response.AssignmentResponse;
import roman.levko.demo.entity.Assignment;
import roman.levko.demo.entity.Client;
import roman.levko.demo.entity.Job;
import roman.levko.demo.entity.Translator;
import roman.levko.demo.repository.AssignmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    TranslatorService translatorService;

    public void create(AssignmentRequest request) {
        assignmentRepository.save(assignmentRequestToAssignment(null, request));
    }


    public void update(Long id, AssignmentRequest request) {
        assignmentRepository.save(assignmentRequestToAssignment(findOne(id), request));
    }

    public void delete(Long id) {
        assignmentRepository.delete(findOne(id));
    }

    private Assignment assignmentRequestToAssignment(Assignment assignment, AssignmentRequest request) {
        if (assignment == null) {
            assignment = new Assignment();
        }

        Client client = clientService.findOne(request.getClientId());
        Translator translator = translatorService.findOne(request.getClientId());

        return assignment;
    }

    public List<AssignmentResponse> findAll() {
        return assignmentRepository.findAll()
                .stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }

    public Assignment findOne(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignment with id " + id + " not exists"));
    }
}
