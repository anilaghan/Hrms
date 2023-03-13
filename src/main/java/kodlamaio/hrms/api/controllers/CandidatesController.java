package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.requests.candidateRequest.CreatCandidateRequest;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import kodlamaio.hrms.entities.concrates.Candidate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private final CandidatesService candidatesService;


    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping
    public List<GetAllCandidatesResponse> getAllCandidatesResponses(){
        return candidatesService.getAll();
    }

    @PostMapping

    public Candidate add( @RequestBody @Valid CreatCandidateRequest creatCandidateRequest){
    return  candidatesService.add(creatCandidateRequest);
    }

    @GetMapping("/{id}")

    public Candidate getCandidateById(@PathVariable Long id){
        return candidatesService.getCandidateById(id);
    }
}
