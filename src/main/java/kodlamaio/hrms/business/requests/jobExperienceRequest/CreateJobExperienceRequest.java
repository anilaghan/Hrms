package kodlamaio.hrms.business.requests.jobExperienceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobExperienceRequest {
    private String companyName;
    private String jobPositon;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean jobStatus;
}
