package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.form.TemperatureForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Temperature;
import lukec.zavrsni.petcare.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/temperature")
@CrossOrigin
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @PostMapping
    public ResponseEntity<Void> enterTemperature(@RequestBody TemperatureForm temperatureForm){

        temperatureService.save(temperatureForm);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/graph-stats")
    public ResponseEntity<List<Temperature>> getGraphStatsForTimeframe(@RequestBody TimeframeForm timeframeForm){
        List<Temperature> temperatureList = temperatureService.getStatsInTimeframe(timeframeForm);

        return new ResponseEntity<>(temperatureList, HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<Double> getCurrentValue(){
        Double value = temperatureService.getCurrent();

        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<Double> getMaxValue(){
        Double value = temperatureService.getMax();

        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/min")
    public ResponseEntity<Double> getMinValue(){
        Double value = temperatureService.getMin();

        return new ResponseEntity<>(value, HttpStatus.OK);
    }


}
