package kodlamaio.hrms.business.requests.educationRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationRequest {
    private String schoolName;

    private String departmanName;

    private LocalDate startDate;

    private LocalDate graduateDate;

    private boolean graduateStatus;
}

