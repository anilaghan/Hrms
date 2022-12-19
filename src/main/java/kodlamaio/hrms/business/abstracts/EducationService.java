package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.entities.concrates.Education;

public interface EducationService {

    Education add(CreateEducationRequest createEducationRequest);
}
