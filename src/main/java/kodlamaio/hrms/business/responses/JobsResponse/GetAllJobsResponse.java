package kodlamaio.hrms.business.responses.JobsResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobsResponse {
    private int id;
    private String name;
}
