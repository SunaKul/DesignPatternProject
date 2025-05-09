package bridge;

public class PomodoroMethod extends StudyMethod {
    public PomodoroMethod(Duration duration) {
        super(duration);
    }

    @Override
    public String getMethodInfo() {
        return "Pomodoro with " + duration.getDurationInfo();
    }
}
