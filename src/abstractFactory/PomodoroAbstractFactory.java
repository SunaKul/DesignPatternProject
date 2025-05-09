package abstractFactory;

import bridge.*;

public class PomodoroAbstractFactory extends StudyPlanAbstractFactory {
    @Override
    public StudyPlan createStudyPlan(Duration duration) {
        StudyMethod method = new PomodoroMethod(duration);
        return new StudyPlan(method.getMethodInfo());
    }
}
