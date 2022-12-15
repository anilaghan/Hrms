package kodlamaio.hrms.business.responses.EmployerResponse;

import kodlamaio.hrms.entities.concrates.Candidate;
import kodlamaio.hrms.entities.concrates.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerResponse {
    private Long id;
    private String companyName;
    private String webSite;
    private String email;
    private String phone;


    public GetAllEmployerResponse (Employer employer){

        this.id = employer.getId();
        this.companyName = employer.getCompanyName();
        this.webSite = employer.getWebSite();
        this.email = employer.getEmail();
        this.phone = employer.getPhone();


    }
}
