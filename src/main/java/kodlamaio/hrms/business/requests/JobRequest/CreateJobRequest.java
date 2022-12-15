package kodlamaio.hrms.business.requests.JobRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobRequest {
    @NotBlank
    @NotNull
    private String name;
}
