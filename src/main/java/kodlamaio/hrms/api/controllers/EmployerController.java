package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.requests.EmployerRequest.CreateEmployerRequest;
import kodlamaio.hrms.business.responses.EmployerResponse.GetAllEmployerResponse;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employies")
public class EmployerController {
    private final EmployerService employerService;


    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public List<GetAllEmployerResponse> getAllEmployerResponses(){return employerService.getAll();}

    @PostMapping

    public Employer add(@RequestBody @Valid CreateEmployerRequest createEmployerRequest) {
        return employerService.add(createEmployerRequest);
    }

    @GetMapping("/{id}")
    public List<AdvertiseWithEmployerDto> getEmployerWithAdvertise (@PathVariable Long id){
        return employerService.getEmployerWithAdvertises(id);
    }

    @PutMapping("/advertiseStatus")
    public Employer jobAdvertiseStatus(@RequestBody Long employerId, Long advertiseId ){
        return employerService.employerAdvertisePasive(employerId,advertiseId);
    }


}
