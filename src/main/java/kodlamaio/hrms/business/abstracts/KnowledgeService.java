package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.entities.concrates.Skills;

public interface KnowledgeService {
    Skills add(CreateKnowledgeRequest createKnowledgeRequest);

    void delete(long id);

    Skills getKnowledgeById(Long id);
}
