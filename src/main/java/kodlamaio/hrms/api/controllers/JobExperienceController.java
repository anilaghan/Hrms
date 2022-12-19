package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.entities.concrates.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobExperiences")
public class JobExperienceController {
    @Autowired
    private final JobExperienceService jobExperienceService;

    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping
    JobExperience add(@RequestBody CreateJobExperienceRequest createJobExperienceRequest){
        return jobExperienceService.add(createJobExperienceRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){jobExperienceService.delete(id);
    }

    @GetMapping
    public List<JobExperience> getAllSorted(){
        return jobExperienceService.getAllSorted();
    }
}
