package lukec.zavrsni.petcare.form;


import java.time.LocalDateTime;

public class TimeframeForm {

    private LocalDateTime startTime;

    private LocalDateTime endTime;



    // ------ getters and setters ------

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
