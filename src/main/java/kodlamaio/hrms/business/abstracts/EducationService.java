package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.entities.concrates.Education;

import java.util.List;

public interface EducationService {

    Education add(CreateEducationRequest createEducationRequest);

    void delete(Long id);

    List<Education> getAllSorted();

    Education getEducationById(Long id);
}
