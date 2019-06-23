package lukec.zavrsni.petcare.service;

import lukec.zavrsni.petcare.form.TemperatureForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Temperature;

import java.util.List;

public interface TemperatureService {

    void save(TemperatureForm temperatureForm);

    List<Temperature> getStatsInTimeframe(TimeframeForm timeframeForm);

    Double getCurrent();

    Double getMax();

    Double getMin();

}
