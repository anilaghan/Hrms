package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.AdvertiseService;
import kodlamaio.hrms.business.requests.jobAdvertiseRequest.CreateJobAdvertiseRequest;
import kodlamaio.hrms.dataAccess.AdvertiseRepository;
import kodlamaio.hrms.dataAccess.EmployerRepository;
import kodlamaio.hrms.dataAccess.JobsRepository;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.Job;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class AdvertiseManager implements AdvertiseService {
    @Autowired
    private AdvertiseRepository advertiseRepository;
    @Autowired
    private JobsRepository jobsRepository;
    @Autowired
    private EmployerRepository employerRepository;


    @Override
    public JobAdvertise add(CreateJobAdvertiseRequest createJobAdvertiseRequest) {
        JobAdvertise jobAdvertise = new JobAdvertise();
        Job job = jobsRepository.getReferenceById(createJobAdvertiseRequest.getJobId());
        Employer employer = employerRepository.getReferenceById(createJobAdvertiseRequest.getEmployerId());
        jobAdvertise.setAdvertiseStatus(true);
        jobAdvertise.setJob(job);
        jobAdvertise.setCity(createJobAdvertiseRequest.getCity());
        jobAdvertise.setTitle(createJobAdvertiseRequest.getTitle());
        jobAdvertise.setMinSalary(createJobAdvertiseRequest.getMinSalary());
        jobAdvertise.setMaxSalary(createJobAdvertiseRequest.getMaxSalary());
        jobAdvertise.setOpenPositions(createJobAdvertiseRequest.getOpenPositions());
        jobAdvertise.setLastApplicationDate(createJobAdvertiseRequest.getLastApplicationDate());
        jobAdvertise.setDescription(createJobAdvertiseRequest.getDescription());
        jobAdvertise.setEmployer(employer);
        jobAdvertise.setPublishDate(createJobAdvertiseRequest.getPublishDate());
        return advertiseRepository.save(jobAdvertise);
    }


    @Override
    public List<AdvertiseWithEmployerDto> getAllByActive() {
        return activeList();
    }

    @Override
    public Set<AdvertiseWithEmployerDto> getAllByActiveSorted() {
        return new TreeSet<>(activeList());
    }

    @Override
    public List<JobAdvertise> getAllSorted() {

        return advertiseRepository.findAll(Sort.by(Sort.Direction.DESC,"publishDate"));
    }

    @Override
    public boolean revokeAdvertise(Long id) {
        JobAdvertise advertise = advertiseRepository.findById(id).orElseThrow();
        advertise.setAdvertiseStatus(false);
        advertiseRepository.save(advertise);
        return true;
    }


    private List<AdvertiseWithEmployerDto> activeList(){
        List<AdvertiseWithEmployerDto> allList = advertiseRepository.getAdvertiseWithEmployer();
        List<AdvertiseWithEmployerDto> result = new ArrayList<>();
        for(AdvertiseWithEmployerDto advertise:allList){
            if(advertise.isStatus()){
                result.add(advertise);
            }
        }
        return result;
    }


}
