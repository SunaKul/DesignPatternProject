package bridge;

public class DeepWorkMethod extends StudyMethod {
    public DeepWorkMethod(Duration duration) {
        super(duration);
    }

    @Override
    public String getMethodInfo() {
        return "Deep work method with " + duration.getDurationInfo();
    }
}
