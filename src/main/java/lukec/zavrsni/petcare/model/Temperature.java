package lukec.zavrsni.petcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEMPERATURE")
public class Temperature {

    @Id
    @Column(name = "TIMESTAMP", nullable = false, unique = true)
    private LocalDateTime timestamp;

    @Column(name = "VALUE", nullable = false)
    private Double value;



    // getters and setters

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
