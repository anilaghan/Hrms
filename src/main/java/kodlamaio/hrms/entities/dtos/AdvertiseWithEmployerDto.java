package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concrates.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseWithEmployerDto{
    private Long id;
    private String companyName;
    private String jobPosition;
    private String openPositions;
    private LocalDate publishDate;
    private LocalDate lastApplicationDate;
    private boolean Status;

}
