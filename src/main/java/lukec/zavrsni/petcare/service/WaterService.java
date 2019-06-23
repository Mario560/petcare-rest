package lukec.zavrsni.petcare.service;

import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.form.WaterForm;
import lukec.zavrsni.petcare.model.Water;

import java.time.LocalDateTime;
import java.util.List;

public interface WaterService {

    void save(WaterForm waterForm);

    List<Water> getStatsInTimeframe(TimeframeForm timeframeForm);

    Double getDrankToday();

    LocalDateTime getLastTimeDrankToday();

    Double getCurrentWeight();

}
