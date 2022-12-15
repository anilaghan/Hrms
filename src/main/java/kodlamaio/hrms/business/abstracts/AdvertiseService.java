package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.JobAdvertiseRequest.CreateJobAdvertiseRequest;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface AdvertiseService {

    JobAdvertise add(CreateJobAdvertiseRequest createJobAdvertiseRequest);

    List<AdvertiseWithEmployerDto> getAllByActive();
    Set<AdvertiseWithEmployerDto> getAllByActiveSorted();

    List<JobAdvertise> getAllSorted();

    boolean revokeAdvertise(Long id);
}
