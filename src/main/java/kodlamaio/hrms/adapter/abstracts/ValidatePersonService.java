package kodlamaio.hrms.adapter.abstracts;

import kodlamaio.hrms.business.requests.CandidateRequest.CreatCandidateRequest;

public interface ValidatePersonService {
    boolean validate(CreatCandidateRequest creatCandidateRequest);
}
