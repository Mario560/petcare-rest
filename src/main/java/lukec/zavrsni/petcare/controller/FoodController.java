package lukec.zavrsni.petcare.controller;

import lukec.zavrsni.petcare.form.FoodForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Food;
import lukec.zavrsni.petcare.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@SessionAttributes({"refillStatus"})
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    Boolean refillStatus = false;


    @PostMapping
    public ResponseEntity<Void> enterFood(@RequestBody FoodForm foodForm){
        foodService.save(foodForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/refill")
    public ResponseEntity<Void> refillFood(){

        refillStatus = true;

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/refill-status")
    public ResponseEntity<Void> refillFoodStatus(){

        if(refillStatus == true){
            refillStatus = false;
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/graph-stats")
    public ResponseEntity<List<Food>> getGraphStatsForTimeframe(@RequestBody TimeframeForm timeframeForm){
        List<Food> foodList = foodService.getStatsInTimeframe(timeframeForm);

        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }
}
