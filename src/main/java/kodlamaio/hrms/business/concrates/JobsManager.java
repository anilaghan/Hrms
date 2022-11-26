package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.requests.JobsRequest.CreateJobRequest;
import kodlamaio.hrms.business.requests.JobsRequest.UpdateJobRequest;
import kodlamaio.hrms.business.responses.JobsResponse.GetAllJobsResponse;
import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.dataAccess.JobsRepository;
import kodlamaio.hrms.entities.concrates.Jobs;
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
        List<Jobs> jobs = jobsRepository.findAll();
        List<GetAllJobsResponse> jobsResponses = new ArrayList<>();

        for (Jobs job:jobs){
            GetAllJobsResponse responseItem = new GetAllJobsResponse();
            responseItem.setId(job.getId());
            responseItem.setName(job.getName());

            jobsResponses.add(responseItem);
        }
        return jobsResponses;
    }

    @Override
    public Jobs add(CreateJobRequest createJobRequest) throws Exception {
        Jobs job = new Jobs();
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
    public Jobs update(int id, UpdateJobRequest updateJobRequest) {
        Optional<Jobs> inDbJob = jobsRepository.findById(id);
        if(inDbJob.isPresent()){
            Jobs job1 = inDbJob.get();
            job1.setName(updateJobRequest.getName());
            return jobsRepository.save(job1);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        jobsRepository.deleteById(id);
    }
}
