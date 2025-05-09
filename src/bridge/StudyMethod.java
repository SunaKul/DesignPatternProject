package bridge;

public abstract class StudyMethod {
    protected Duration duration;

    public StudyMethod(Duration duration) {
        this.duration = duration;
    }

    public abstract String getMethodInfo();
}
