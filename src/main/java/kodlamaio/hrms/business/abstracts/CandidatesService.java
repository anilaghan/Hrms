package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.CandidatesRequest.CreatCandidateRequest;
import kodlamaio.hrms.business.requests.CandidatesRequest.UpdateCandidateRequest;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import kodlamaio.hrms.entities.concrates.Candidate;

import java.util.List;

public interface CandidatesService {
    List<GetAllCandidatesResponse> getAll();
    Candidate add(CreatCandidateRequest creatCandidateRequest);
    Candidate update(int id, UpdateCandidateRequest updateCandidateRequest);
    void delete(int id);




}
