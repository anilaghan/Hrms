package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private final CandidatesService candidatesService;


    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping("/getAll")
    public List<GetAllCandidatesResponse> getAllCandidatesResponses(){
        return candidatesService.getAll();
    }

}
