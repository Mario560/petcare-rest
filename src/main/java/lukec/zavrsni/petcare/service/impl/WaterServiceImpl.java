package lukec.zavrsni.petcare.service.impl;

import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.form.WaterForm;
import lukec.zavrsni.petcare.model.Water;
import lukec.zavrsni.petcare.repository.WaterRepository;
import lukec.zavrsni.petcare.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    private WaterRepository waterRepository;

    @Override
    public void save(WaterForm waterForm) {
        Water water = new Water();
        water.setWeight(Double.valueOf(waterForm.getWeight()));
        water.setTimestamp(LocalDateTime.now());

        waterRepository.save(water);
    }

    @Override
    public List<Water> getStatsInTimeframe(TimeframeForm timeframeForm) {
        return waterRepository.getAllByTimestampBetween(timeframeForm.getStartTime(), timeframeForm.getEndTime());
    }

    @Override
    public Double getDrankThatDay(TimeframeForm timeframeForm) {

        LocalDateTime start = timeframeForm.getStartTime().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = timeframeForm.getEndTime().withHour(23).withMinute(59).withSecond(59);
        List<Water> water = waterRepository.getAllByTimestampBetween(start, end);

        if(water.isEmpty()) {
            return 0d;
        }

        Double drankToday = 0d;
        Double lastWeigth = water.get(0).getWeight();
        for (Water w : water) {
            if(w.getWeight() < lastWeigth){
                drankToday += lastWeigth - w.getWeight();
            }
            lastWeigth = w.getWeight();
        }

        return (double)Math.round(drankToday);
    }

    @Override
    public LocalDateTime getLastTimeDrankToday() {

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = today.withHour(23).withMinute(59).withSecond(59);
        List<Water> water = waterRepository.getAllByTimestampBetween(start, end);

        if(water.isEmpty()) {
            return null;
        }

        LocalDateTime lastDrank = null;
        Double lastWeigth = water.get(0).getWeight();
        for (Water w : water) {
            if(w.getWeight() < lastWeigth){
                lastDrank = w.getTimestamp();
            }
            lastWeigth = w.getWeight();
        }

        return lastDrank;
    }

    @Override
    public Double getCurrentWeight() {
        Double weight = waterRepository.getCurrentWeight();

        if(weight == null){
            return 0d;
        }

        return (double)Math.round(weight);
    }
}
