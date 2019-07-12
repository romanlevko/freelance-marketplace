package roman.levko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.levko.demo.dto.request.JobRequest;
import roman.levko.demo.service.JobService;

@RestController
@RequestMapping ("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping
    public void create(@RequestBody JobRequest request) {
        jobService.create(request);
    }


    @PutMapping
    public void update(Long id, @RequestBody JobRequest request) {
        jobService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        jobService.delete(id);
    }
}


