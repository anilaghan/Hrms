package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.requests.JobsRequest.CreateJobRequest;
import kodlamaio.hrms.business.requests.JobsRequest.UpdateJobRequest;
import kodlamaio.hrms.business.responses.JobsResponse.GetAllJobsResponse;
import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.entities.concrates.Jobs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/jobs")
public class JobsController {
    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping
    public List<GetAllJobsResponse> getAll() {
        return this.jobsService.getAll();
    }

    @PostMapping
    public void add (@RequestBody CreateJobRequest createJobRequest) throws Exception{
        jobsService.add(createJobRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jobs> update(@PathVariable int id,@RequestBody UpdateJobRequest updateJobRequest){
        Jobs job = jobsService.update(id, updateJobRequest);
        if(Objects.nonNull(job)){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    };

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        jobsService.delete(id);
    }




}
