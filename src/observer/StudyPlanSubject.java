package observer;

public interface StudyPlanSubject {
    void attach(StudyPlanObserver observer);
    void detach(StudyPlanObserver observer);
    void notifyObservers(String planInfo);
}
