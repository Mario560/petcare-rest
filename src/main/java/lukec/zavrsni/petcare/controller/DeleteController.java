package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.repository.FoodRepository;
import lukec.zavrsni.petcare.repository.TemperatureRepository;
import lukec.zavrsni.petcare.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
@CrossOrigin
public class DeleteController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private WaterRepository waterRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @GetMapping
    public ResponseEntity<Void> reset(){

        foodRepository.deleteWhereGraduationDay();
        waterRepository.deleteWhereGraduationDay();
        temperatureRepository.deleteWhereGraduationDay();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
