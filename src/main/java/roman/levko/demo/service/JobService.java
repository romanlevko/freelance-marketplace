package roman.levko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roman.levko.demo.dto.request.JobRequest;
import roman.levko.demo.entity.Category;
import roman.levko.demo.entity.Job;
import roman.levko.demo.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    CategoryService categoryService;

    public void create(JobRequest request) {
        jobRepository.save(jobRequestToJob(null, request));
    }

    public void update(Long id, JobRequest request) {
        jobRepository.save(jobRequestToJob(findOne(id), request));
    }

    public void delete(Long id) {
        jobRepository.delete(findOne(id));
    }

    private Job jobRequestToJob(Job job, JobRequest request) {
        if (job == null) {
            job = new Job();
        }

        Category category =
                categoryService.findOne(request.getCategoryId());
        job.setCategory(category);
        job.setPricePerWord(request.getPricePerWord());
        job.setName(request.getName());
        job.setDescription(request.getDescription());
        job.setDeadline(request.getDeadline());
        job.setVolume(request.getVolume());
        job.setSourceLanguage(request.getSourceLanguage());
        job.setTargetLanguage(request.getTargetLanguage());
        return job;
    }

    public Job findOne(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not exists"));
    }
}

