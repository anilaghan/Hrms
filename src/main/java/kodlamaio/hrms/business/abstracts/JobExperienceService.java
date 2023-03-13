package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.entities.concrates.JobExperience;

import java.util.List;

public interface JobExperienceService {

    JobExperience add(CreateJobExperienceRequest createJobExperienceRequest);

    void delete(Long id);

    List<JobExperience> getAllSorted();

    JobExperience jobExperienceGetById(Long id);
}
