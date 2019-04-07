package lukec.zavrsni.petcare.repository;

import lukec.zavrsni.petcare.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, LocalDateTime> {
}
