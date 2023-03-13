package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.KnowledgeService;
import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.dataAccess.KnowledgeRepository;
import kodlamaio.hrms.entities.concrates.Skills;
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
    public Skills add(CreateKnowledgeRequest createKnowledgeRequest) {
        Skills skills = new Skills();
        skills.setName(createKnowledgeRequest.getName());
        return knowledgeRepository.save(skills);
    }

    @Override
    public void delete(long id) {
        knowledgeRepository.deleteById(id);
    }

    @Override
    public Skills getKnowledgeById(Long id) {
        return knowledgeRepository.findById(id).orElseThrow();
    }
}
