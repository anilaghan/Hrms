package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.cvRequest.CvCreateRequest;
import kodlamaio.hrms.entities.concrates.Cv;

public interface CvService {
    Cv add(CvCreateRequest cvCreateRequest);
}
