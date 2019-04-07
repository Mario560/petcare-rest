package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface WaterRepository extends JpaRepository<Water, LocalDateTime> {
}
