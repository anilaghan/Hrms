package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concrates.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseWithEmployerDto implements Comparable<AdvertiseWithEmployerDto>{
    private Long id;
    private String companyName;
    private String jobPosition;
    private String openPositions;
    private LocalDate publishDate;
    private LocalDate lastApplicationDate;
    private boolean Status;

    @Override
    public int compareTo(AdvertiseWithEmployerDto o) {
        if(this.getPublishDate().isBefore(o.getPublishDate())){
            return 1;
        }
        else if(this.getPublishDate().isAfter(o.getPublishDate())){
            return -1;
        }else {
            return 0;
        }
    }
}
