package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.form.WaterForm;
import lukec.zavrsni.petcare.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/water")
@CrossOrigin
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping
    public ResponseEntity<Void> enterWater(@RequestBody WaterForm waterForm){
        System.out.println("water " + waterForm.getWeight());
        waterService.save(waterForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/drank-today")
    public ResponseEntity<Double> ateToday(){

        Double ateToday = waterService.getDrankToday();

        return new ResponseEntity<>(ateToday, HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<Double> currentWeight(){

        return new ResponseEntity<>(waterService.getCurrentWeight(), HttpStatus.OK);
    }

    @GetMapping("/last-time-drank-today")
    public ResponseEntity<LocalDateTime> lastTimeateToday(){

        return new ResponseEntity<>(waterService.getLastTimeDrankToday(), HttpStatus.OK);
    }

}
