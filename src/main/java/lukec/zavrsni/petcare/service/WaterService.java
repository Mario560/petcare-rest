package lukec.zavrsni.petcare.service;

import lukec.zavrsni.petcare.form.WaterForm;

import java.time.LocalDateTime;

public interface WaterService {

    void save(WaterForm waterForm);

    Double getDrankToday();

    LocalDateTime getLastTimeDrankToday();

    Double getCurrentWeight();

}
