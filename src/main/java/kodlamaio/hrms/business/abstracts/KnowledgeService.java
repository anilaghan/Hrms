package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.entities.concrates.Knowledge;

public interface KnowledgeService {
    Knowledge add(CreateKnowledgeRequest createKnowledgeRequest);

    void delete(long id);
}
