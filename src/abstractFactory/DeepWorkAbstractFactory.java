package abstractFactory;

import bridge.*;

public class DeepWorkAbstractFactory extends StudyPlanAbstractFactory {
 public StudyPlan createStudyPlan(Duration duration) {
     StudyMethod method = new DeepWorkMethod(duration);
     return new StudyPlan(method.getMethodInfo());
 }
}
