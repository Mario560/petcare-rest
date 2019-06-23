package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, LocalDateTime> {

    List<Temperature> getAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query(nativeQuery = true, value = "SELECT value from temperature order by timestamp DESC LIMIT 1")
    Double getCurrent();

    @Query(nativeQuery = true, value = "SELECT MAX(value) from temperature where DATE(timestamp) = CURRENT_DATE ")
    Double getMax();

    @Query(nativeQuery = true, value = "SELECT MIN(value) from temperature where DATE(timestamp) = CURRENT_DATE ")
    Double getMin();

}
