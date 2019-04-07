package lukec.zavrsni.petcare.service.impl;

import lukec.zavrsni.petcare.form.TemperatureForm;
import lukec.zavrsni.petcare.model.Temperature;
import lukec.zavrsni.petcare.repository.TemperatureRepository;
import lukec.zavrsni.petcare.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
