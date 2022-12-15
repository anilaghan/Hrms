package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.business.requests.EmployerRequest.CreateEmployerRequest;
import kodlamaio.hrms.business.responses.EmployerResponse.GetAllEmployerResponse;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;

import java.util.List;

public interface EmployerService {
    List<GetAllEmployerResponse> getAll();
    Employer add(CreateEmployerRequest createEmployerRequest);

    List<AdvertiseWithEmployerDto>getEmployerWithAdvertises(Long employerId);
    Employer employerAdvertisePasive(Long employerId, Long advertiseId);




}
