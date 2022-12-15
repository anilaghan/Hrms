package kodlamaio.hrms.business.requests.EmployerRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployerRequest {
    @NotBlank
    @NotNull
    private String companyName;
    @NotBlank
    @NotNull
    private String webSite;
    @NotBlank
    @NotNull
    private String phone;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String repeatPassword;

}
