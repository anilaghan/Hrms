package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.entities.concrates.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/educations")
public class EducationController {
    @Autowired
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    Education add(@RequestBody CreateEducationRequest createEducationRequest){
        return educationService.add(createEducationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        educationService.delete(id);
    }

    @GetMapping
    public List<Education> getAllSorted(){
        return educationService.getAllSorted();
    }
}
