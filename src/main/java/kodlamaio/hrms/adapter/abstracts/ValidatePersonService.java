package kodlamaio.hrms.adapter.abstracts;

import kodlamaio.hrms.business.requests.candidateRequest.CreatCandidateRequest;

public interface ValidatePersonService {
    boolean validate(CreatCandidateRequest creatCandidateRequest);
}
