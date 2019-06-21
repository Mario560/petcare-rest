package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, LocalDateTime> {

    List<Food> getAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query(nativeQuery = true, value = "SELECT timestamp from food where date (timestamp) = CURRENT_DATE order by timestamp DESC LIMIT 1")
    LocalDateTime getLastTimeAteToday();

    @Query(nativeQuery = true, value = "SELECT weight from food order by timestamp DESC LIMIT 1")
    Double getCurrentWeight();
}
