package facade;

import model.PersonalPlanner;
import java.util.List;
import java.util.Random;

public class AssignmentEngine {
    private Random random = new Random();

    public PersonalPlanner selectRandomPlanner(List<PersonalPlanner> planners) {
        if (planners.isEmpty()) return null;
        return planners.get(random.nextInt(planners.size()));
    }
}
