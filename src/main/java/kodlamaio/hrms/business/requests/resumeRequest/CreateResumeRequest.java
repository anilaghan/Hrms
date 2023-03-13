package kodlamaio.hrms.business.requests.resumeRequest;


import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.entities.concrates.Education;
import kodlamaio.hrms.entities.concrates.JobExperience;
import kodlamaio.hrms.entities.concrates.Skills;
import kodlamaio.hrms.entities.concrates.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResumeRequest {

    private String photoLink;
    private String gitLink;
    private String linkedin;
    private String textArea;
    private List<CreateJobExperienceRequest> jobExperiences;
    private List<CreateKnowledgeRequest> skills;
    private List<CreateLanguageRequest> languages;
    private List<CreateEducationRequest> educations;
    private Long candidateId;

}
