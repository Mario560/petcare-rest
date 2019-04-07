package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.form.WaterForm;
import lukec.zavrsni.petcare.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @PostMapping
    public ResponseEntity<Void> enterWater(@RequestBody WaterForm waterForm){
        waterService.save(waterForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
