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

    @Override
    public Double getAteDoday() {

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = today.withHour(23).withMinute(59).withSecond(59);
        List<Food> food = foodRepository.getAllByTimestampBetween(start, end);

        if(food.isEmpty()) {
            return 0d;
        }

        Double ateToday = 0d;
        Double lastWeigth = food.get(0).getWeight();
        for (Food f : food) {
            if(f.getWeight() < lastWeigth){
                ateToday += lastWeigth - f.getWeight();
            }
            lastWeigth = f.getWeight();
        }

        return ateToday;
    }

    @Override
    public LocalDateTime getLastTimeAteToday() {
        LocalDateTime last = foodRepository.getLastTimeAteToday();

        if(last == null){
            return null;
        }

        return last;
    }

    @Override
    public Double getCurrentWeight() {
        Double weight = foodRepository.getCurrentWeight();

        if(weight == null){
            return 0d;
        }

        return weight;
    }
}


