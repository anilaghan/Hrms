package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.requests.jobRequest.CreateJobRequest;
import kodlamaio.hrms.business.requests.jobRequest.UpdateJobRequest;
import kodlamaio.hrms.business.responses.JobsResponse.GetAllJobsResponse;
import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.dataAccess.JobsRepository;
import kodlamaio.hrms.entities.concrates.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobsManager implements JobsService {
    private JobsRepository jobsRepository;

    @Autowired
    private JobsManager(JobsRepository jobsRepository){
        this.jobsRepository=jobsRepository;
    }

    @Override
    public List<GetAllJobsResponse> getAll() {
        List<Job> jobs = jobsRepository.findAll();
        List<GetAllJobsResponse> jobsResponses = new ArrayList<>();

        for (Job job:jobs){
            GetAllJobsResponse responseItem = new GetAllJobsResponse();
            responseItem.setId(job.getId());
            responseItem.setName(job.getName());

            jobsResponses.add(responseItem);
        }
        return jobsResponses;
    }

    @Override
    public Job add(CreateJobRequest createJobRequest) throws Exception {
        Job job = new Job();
        job.setName(createJobRequest.getName());
        if(job.getName().isEmpty()){
            throw new Exception("İş Adı Boş Bırakılamaz.");
        }
        for(GetAllJobsResponse jobsResponse:getAll()){
            if(jobsResponse.getName().equals(job.getName())){
                throw new Exception("Aynı isimde bir iş mevcut");
            }
        }

        return jobsRepository.save(job);
    }

    @Override
    public Job update(Long id, UpdateJobRequest updateJobRequest) {
        Optional<Job> inDbJob = jobsRepository.findById(id);
        if(inDbJob.isPresent()){
            Job job1 = inDbJob.get();
            job1.setName(updateJobRequest.getName());
            return jobsRepository.save(job1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        jobsRepository.deleteById(id);
    }
}
