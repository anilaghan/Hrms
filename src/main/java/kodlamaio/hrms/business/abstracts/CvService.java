package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.cvRequest.CreateCvRequest;
import kodlamaio.hrms.entities.concrates.Cv;

public interface CvService {
    Cv add(CreateCvRequest createCvRequest);

    void delete(Long id);
}
