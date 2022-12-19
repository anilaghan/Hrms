package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.KnowledgeService;
import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.dataAccess.KnowledgeRepository;
import kodlamaio.hrms.entities.concrates.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeManager implements KnowledgeService {

    @Autowired
    private final KnowledgeRepository knowledgeRepository;

    public KnowledgeManager(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    @Override
    public Knowledge add(CreateKnowledgeRequest createKnowledgeRequest) {
        Knowledge knowledge = new Knowledge();
        knowledge.setName(createKnowledgeRequest.getName());
        return knowledgeRepository.save(knowledge);
    }

    @Override
    public void delete(long id) {
        knowledgeRepository.deleteById(id);
    }
}
