package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.jobRequest.CreateJobRequest;
import kodlamaio.hrms.business.requests.jobRequest.UpdateJobRequest;
import kodlamaio.hrms.business.responses.JobsResponse.GetAllJobsResponse;
import kodlamaio.hrms.entities.concrates.Job;

import java.util.List;

public interface JobsService {
    List<GetAllJobsResponse> getAll();
    Job add(CreateJobRequest createJobRequest) throws Exception;
    Job update(Long id, UpdateJobRequest updateJobRequest);
    void delete (Long id);

}
