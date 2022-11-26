package kodlamaio.hrms.business.responses.CandidatesResponse;

import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Jobs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCandidatesResponse {

    private int id;
    private String identityNumber;
    private String firstName;
    private String lastName;


    public GetAllCandidatesResponse (Candidate candidate){

        this.id = candidate.getId();
        this.identityNumber = candidate.getIdentityNumber();
        this.firstName = candidate.getFirstName();
        this.lastName = candidate.getLastName();


    }
}
