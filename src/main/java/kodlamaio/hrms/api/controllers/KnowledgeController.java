package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.KnowledgeService;
import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.entities.concrates.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/knowledges")
public class KnowledgeController {
    @Autowired
    private final KnowledgeService knowledgeService;

    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    @PostMapping
    Skills add(@RequestBody CreateKnowledgeRequest createKnowledgeRequest){
        return knowledgeService.add(createKnowledgeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        knowledgeService.delete(id);
    }
}
