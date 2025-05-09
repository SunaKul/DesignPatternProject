package abstractFactory;

import bridge.Duration;

public abstract class StudyPlanAbstractFactory {
    public abstract StudyPlan createStudyPlan(Duration duration);
}
