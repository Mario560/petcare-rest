package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<Water, LocalDateTime> {

    List<Water> getAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query(nativeQuery = true, value = "SELECT timestamp from water where date (timestamp) = CURRENT_DATE order by timestamp DESC LIMIT 1")
    LocalDateTime getLastTimeDrankToday();

    @Query(nativeQuery = true, value = "SELECT weight from water order by timestamp DESC LIMIT 1")
    Double getCurrentWeight();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM water where date (timestamp) =  CURRENT_DATE")
    void deleteWhereGraduationDay();
}
