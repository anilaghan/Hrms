package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.candidateRequest.CreatCandidateRequest;
import kodlamaio.hrms.business.requests.candidateRequest.UpdateCandidateRequest;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import kodlamaio.hrms.entities.concrates.Candidate;

import java.util.List;

public interface CandidatesService {
    List<GetAllCandidatesResponse> getAll();
    Candidate add(CreatCandidateRequest creatCandidateRequest);
    Candidate update(Long id, UpdateCandidateRequest updateCandidateRequest);
    void delete(Long id);




}
