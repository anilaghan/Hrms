package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.AdvertiseService;
import kodlamaio.hrms.business.requests.JobAdvertiseRequest.CreateJobAdvertiseRequest;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/advertises")
public class AdvertiseController {
    private final AdvertiseService advertiseService;

    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }


    @PostMapping
    public JobAdvertise add(@RequestBody CreateJobAdvertiseRequest createJobAdvertiseRequest){
        return advertiseService.add(createJobAdvertiseRequest);
    }

    @GetMapping
    public List<AdvertiseWithEmployerDto> getAdvertiseWithEmployerDetails(){
        return advertiseService.getAllByActive();
    }

    @GetMapping("/getAllSorted")
    public ResponseEntity<?> getAllSorted(){
        return new ResponseEntity (advertiseService.getAllByActiveSorted(), HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public boolean revokeAdvertise(@PathVariable Long id){
        return advertiseService.revokeAdvertise(id);

    }

    @GetMapping("/getAllS")
    public List<JobAdvertise> getAllS(){
        return advertiseService.getAllSorted();
    }
}
