package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.levko.demo.dto.request.JobRequest;
import roman.levko.demo.service.JobService;

import javax.validation.Valid;

@RestController
@RequestMapping ("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping
    public void create(@Valid @RequestBody JobRequest request) {
        jobService.create(request);
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody JobRequest request) {
        jobService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        jobService.delete(id);
    }
}


