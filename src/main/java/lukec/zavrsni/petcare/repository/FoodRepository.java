package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, LocalDateTime> {

    List<Food> getAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);
}
