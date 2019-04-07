package lukec.zavrsni.petcare.service.impl;

import lukec.zavrsni.petcare.form.FoodForm;
import lukec.zavrsni.petcare.form.TimeframeForm;
import lukec.zavrsni.petcare.model.Food;
import lukec.zavrsni.petcare.repository.FoodRepository;
import lukec.zavrsni.petcare.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public void save(FoodForm foodForm) {
        Food food = new Food();
        food.setWeight(Double.valueOf(foodForm.getWeight()));
        food.setTimestamp(LocalDateTime.now());

        foodRepository.save(food);
    }

    @Override
    public List<Food> getStatsInTimeframe(TimeframeForm timeframeForm) {


        return foodRepository.getAllByTimestampBetween(timeframeForm.getStartTime(), timeframeForm.getEndTime());
    }
}


