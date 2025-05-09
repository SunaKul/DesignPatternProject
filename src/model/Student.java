package model;

import observer.StudyPlanObserver;

public class Student extends User implements StudyPlanObserver {
    public Student(String username) {
        super(username);
    }

    @Override
    public void displayUserType() {
        System.out.println(username + " is a Student.");
    }

    @Override
    public void update(String planInfo) {
        System.out.println( username + " has been assigned a new study plan: " + planInfo);
    }
}
