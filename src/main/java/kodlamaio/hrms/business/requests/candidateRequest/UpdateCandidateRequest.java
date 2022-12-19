package kodlamaio.hrms.business.requests.candidateRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCandidateRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String yearOfBirth;
    private String identityNumber;
    private String email;
    private String password;
    private String repeatPassword;
}
