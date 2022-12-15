package kodlamaio.hrms.business.requests.cvRequest;

import kodlamaio.hrms.entities.concrates.Education;
import kodlamaio.hrms.entities.concrates.JobExperiance;
import kodlamaio.hrms.entities.concrates.Knowledge;
import kodlamaio.hrms.entities.concrates.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvCreateRequest {

    private String photoLink;
    private String gitLink;
    private String linkedin;
    private String textArea;
    private List<JobExperiance> jobExperianceList;
    private List<Knowledge> knowledges;
    private List<Language> languages;
    private List<Education> educations;
    private Long candidateId;

}
