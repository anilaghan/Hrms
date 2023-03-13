package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.requests.resumeRequest.CreateResumeRequest;
import kodlamaio.hrms.entities.concrates.Resume;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cv")
public class CvController {
    private final ResumeService resumeService;

    public CvController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
    @PostMapping
    Resume add(@RequestBody CreateResumeRequest createResumeRequest){
        return resumeService.add(createResumeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        resumeService.delete(id);
    }

/*   // @GetMapping("/{id}")
 //   public Resume getCandidateCv (@PathVariable Long id){
        return resumeService.getCandidateCv(id);
    }
    */
    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id){
        return resumeService.getById(id);
    }

}
