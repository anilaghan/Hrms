package kodlamaio.hrms.business.requests.cvRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvRequest {

    private String photoLink;
    private String gitLink;
    private String linkedin;
    private String textArea;
    private Long jobExperienceId;
    private Long knowledgeId;
    private Long languageId;
    private Long educationId;
    private Long candidateId;

}
