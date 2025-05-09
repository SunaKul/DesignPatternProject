package model;

import observer.StudyPlanSubject;
import observer.StudyPlanObserver;

import java.util.ArrayList;
import java.util.List;

import abstractFactory.StudyPlan;

public class PersonalPlanner extends User implements StudyPlanSubject {
    private List<StudyPlanObserver> observers = new ArrayList<>();

    public PersonalPlanner(String username) {
        super(username);
    }

    @Override
    public void displayUserType() {
        System.out.println(username + " is a Personal Planner.");
    }

    public void assignStudent(Student student) {
        if (!observers.contains(student)) {
            attach(student);
        }
    }

    @Override
    public void attach(StudyPlanObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(StudyPlanObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String planInfo) {
        for (StudyPlanObserver observer : observers) {
            observer.update(planInfo);
        }
    }
    
    public void makePlan(StudyPlan plan) {
        System.out.println("\n" + this.getUsername() + " creates new plan: " + plan.getPlanDetails());
        
        System.out.print("Notifying students: ");
        for (StudyPlanObserver observer : observers) {
            if (observer instanceof Student) {
                System.out.print(((Student) observer).getUsername() + " ");
            }
        }
        System.out.println(); // newline after student list

        // Then notify separately
        for (StudyPlanObserver observer : observers) {
            observer.update(plan.getPlanDetails());
        }
    }


}
