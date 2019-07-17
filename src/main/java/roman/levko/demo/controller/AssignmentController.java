package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.levko.demo.dto.request.AssignmentRequest;
import roman.levko.demo.dto.response.AssignmentResponse;
import roman.levko.demo.service.AssignmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public void create(@Valid @RequestBody AssignmentRequest request) {
        assignmentService.create(request);
    }

    @GetMapping
    public List<AssignmentResponse> findAll() {
        return assignmentService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody AssignmentRequest request) {
        assignmentService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        assignmentService.delete(id);
    }
}
