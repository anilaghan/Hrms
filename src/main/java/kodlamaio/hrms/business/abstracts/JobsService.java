package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.JobsRequest.CreateJobRequest;
import kodlamaio.hrms.business.requests.JobsRequest.UpdateJobRequest;
import kodlamaio.hrms.business.responses.JobsResponse.GetAllJobsResponse;
import kodlamaio.hrms.entities.concrates.Jobs;

import java.util.List;

public interface JobsService {
    List<GetAllJobsResponse> getAll();
    Jobs add(CreateJobRequest createJobRequest) throws Exception;
    Jobs update(int id, UpdateJobRequest updateJobRequest);

    void delete (int id);

}
