package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.resumeRequest.CreateResumeRequest;
import kodlamaio.hrms.entities.concrates.Resume;

public interface ResumeService {
    Resume add(CreateResumeRequest createResumeRequest);

    void delete(Long id);

    Resume getCandidateCv(Long id);

    Resume getById(Long id);
}
