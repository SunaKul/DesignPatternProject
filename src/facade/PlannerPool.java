package facade;

import model.PersonalPlanner;
import java.util.List;

public class PlannerPool {
    private List<PersonalPlanner> planners;

    public PlannerPool(List<PersonalPlanner> planners) {
        this.planners = planners;
    }

    public List<PersonalPlanner> getPlanners() {
        return planners;
    }
}
