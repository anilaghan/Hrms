package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.requests.cvRequest.CreateCvRequest;
import kodlamaio.hrms.entities.concrates.Cv;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cv")
public class CvController {
    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }
    @PostMapping
    Cv add(@RequestBody CreateCvRequest createCvRequest){
        return cvService.add(createCvRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cvService.delete(id);
    }
}
