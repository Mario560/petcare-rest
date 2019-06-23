package lukec.zavrsni.petcare.service.impl;

import lukec.zavrsni.petcare.form.TemperatureForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Temperature;
import lukec.zavrsni.petcare.repository.TemperatureRepository;
import lukec.zavrsni.petcare.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public void save(TemperatureForm temperatureForm) {
        Temperature temperature = new Temperature();
        temperature.setValue(Double.valueOf(temperatureForm.getTemperature()));
        temperature.setTimestamp(LocalDateTime.now());

        temperatureRepository.save(temperature);
    }

    @Override
    public List<Temperature> getStatsInTimeframe(TimeframeForm timeframeForm) {
        return temperatureRepository.getAllByTimestampBetween(timeframeForm.getStartTime(), timeframeForm.getEndTime());
    }

    @Override
    public Double getCurrent() {
        return temperatureRepository.getCurrent();
    }

    @Override
    public Double getMax() {
        return temperatureRepository.getMax();
    }

    @Override
    public Double getMin() {
        return temperatureRepository.getMin();
    }
}
