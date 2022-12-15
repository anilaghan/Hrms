package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.requests.cvRequest.CvCreateRequest;
import kodlamaio.hrms.dataAccess.CandidatesRepository;
import kodlamaio.hrms.dataAccess.CvRepository;
import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Cv;

import org.springframework.stereotype.Service;



@Service
public class CvManager implements CvService {
    private final CvRepository cvRepository;

    private final CandidatesRepository candidatesRepository;

    public CvManager(CvRepository cvRepository, CandidatesRepository candidatesRepository) {
        this.cvRepository = cvRepository;
        this.candidatesRepository = candidatesRepository;
    }

    @Override
    public Cv add(CvCreateRequest cvCreateRequest) {

        return null;
    }
}
