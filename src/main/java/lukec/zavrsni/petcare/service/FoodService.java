package lukec.zavrsni.petcare.service;

import lukec.zavrsni.petcare.form.FoodForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Food;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodService {

    void save(FoodForm foodForm);

    List<Food> getStatsInTimeframe(TimeframeForm timeframeForm);

    Double getAteToday();

    LocalDateTime getLastTimeAteToday();

    Double getCurrentWeight();




}
