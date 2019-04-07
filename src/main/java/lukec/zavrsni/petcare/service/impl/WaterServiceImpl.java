package lukec.zavrsni.petcare.service.impl;

import lukec.zavrsni.petcare.form.WaterForm;
import lukec.zavrsni.petcare.model.Water;
import lukec.zavrsni.petcare.repository.WaterRepository;
import lukec.zavrsni.petcare.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
