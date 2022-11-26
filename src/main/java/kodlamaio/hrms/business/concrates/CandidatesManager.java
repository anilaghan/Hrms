package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.requests.CandidatesRequest.CreatCandidateRequest;
import kodlamaio.hrms.business.requests.CandidatesRequest.UpdateCandidateRequest;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import kodlamaio.hrms.dataAccess.CandidatesRepository;
import kodlamaio.hrms.entities.concrates.Candidate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatesManager implements CandidatesService {
    private final CandidatesRepository candidatesRepository;


    public CandidatesManager(CandidatesRepository candidatesRepository){
        this.candidatesRepository = candidatesRepository;
    }

    @Override
    public List<GetAllCandidatesResponse> getAll() {
        return candidatesRepository.findAll().stream().map(GetAllCandidatesResponse::new).collect(Collectors.toList());
    }

    @Override
    public Candidate add(CreatCandidateRequest creatCandidateRequest) {

        return null;
    }

    @Override
    public Candidate update(int id, UpdateCandidateRequest updateCandidateRequest) {

        return null;
    }

    @Override
    public void delete(int id) {

    }
}
