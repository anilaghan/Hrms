package kodlamaio.hrms.business.requests.JobAdvertiseRequest;

import kodlamaio.hrms.entities.concrates.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobAdvertiseRequest {

    private String title;

    private City city;

    private double minSalary;

    private double maxSalary;

    private String openPositions;

    private LocalDate lastApplicationDate;

    private String description;

    private Long jobId;

    private Long employerId;

    private LocalDate publishDate;
}
