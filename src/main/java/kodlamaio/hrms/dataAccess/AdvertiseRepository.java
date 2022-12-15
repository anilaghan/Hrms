package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertiseRepository extends JpaRepository<JobAdvertise,Long> {
    @Query("select new kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto(a.id, e.companyName,j.name,a.openPositions,a.publishDate,a.lastApplicationDate,a.advertiseStatus)" +
            "FROM JobAdvertise a inner join a.employer  e inner join a.job j")
    List<AdvertiseWithEmployerDto> getAdvertiseWithEmployer();


}
