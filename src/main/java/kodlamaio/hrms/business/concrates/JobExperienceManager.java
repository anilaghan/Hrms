package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.dataAccess.JobExperianceRepository;
import kodlamaio.hrms.entities.concrates.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    @Autowired
    private final JobExperianceRepository jobExperianceRepository;

    public JobExperienceManager(JobExperianceRepository jobExperianceRepository) {
        this.jobExperianceRepository = jobExperianceRepository;
    }

    @Override
    public JobExperience add(CreateJobExperienceRequest createJobExperienceRequest) {
        JobExperience jobExperience = new JobExperience();

        jobExperience.setJobPositon(createJobExperienceRequest.getJobPositon());
        jobExperience.setCompanyName(createJobExperienceRequest.getCompanyName());
        jobExperience.setStartDate(createJobExperienceRequest.getStartDate());
        jobExperience.setEndDate(createJobExperienceRequest.getEndDate());
        jobExperience.setJobStatus(createJobExperienceRequest.isJobStatus());
        return jobExperianceRepository.save(jobExperience);
    }

    @Override
    public void delete(Long id) {
        jobExperianceRepository.deleteById(id);
    }

    @Override
    public List<JobExperience> getAllSorted() {
        return jobExperianceRepository.findAll(Sort.by(Sort.Direction.DESC,"EndDate"));
    }

    @Override
    public JobExperience jobExperienceGetById(Long id) {
        return jobExperianceRepository.findById(id).orElseThrow();
    }
}
