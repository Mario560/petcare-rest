package lukec.zavrsni.petcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "WATER")
public class Water {

    @Id
    @Column(name = "TIMESTAMP", nullable = false, unique = true)
    private LocalDateTime timestamp;

    @Column(name = "WEIGHT", nullable = false)
    private Double weight;



    // getters and setters

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
