package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.form.TemperatureForm;
import lukec.zavrsni.petcare.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping
    public String welcomeMsg(){
        System.out.println("tu sam");
        return "hello";
    }

    @PostMapping
    public ResponseEntity<Void> enterTemperature(@RequestBody TemperatureForm temperatureForm){

        System.out.println(temperatureForm.getTemperature() + " at " + LocalDateTime.now());
//        temperatureService.save(temperatureForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
