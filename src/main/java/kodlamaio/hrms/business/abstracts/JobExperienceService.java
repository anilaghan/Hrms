package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.entities.concrates.JobExperience;

public interface JobExperienceService {

    JobExperience add(CreateJobExperienceRequest createJobExperienceRequest);
}
