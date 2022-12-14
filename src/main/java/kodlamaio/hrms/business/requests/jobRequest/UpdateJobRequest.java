package kodlamaio.hrms.business.requests.jobRequest;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateJobRequest {
    private Long id;
    @NotBlank
    @NotNull
    private String name;
}
