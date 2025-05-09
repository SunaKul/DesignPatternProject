package main;

import bridge.*;
import abstractFactory.*;
import facade.*;
import iterator.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create 5 Students
        Student s1 = new Student("alice");
        Student s2 = new Student("bob");
        Student s3 = new Student("carol");
        Student s4 = new Student("dave");
        Student s5 = new Student("eve");

        // Create 2 Personal Planners
        PersonalPlanner p1 = new PersonalPlanner("planner_jane");
        PersonalPlanner p2 = new PersonalPlanner("planner_john");

        // Create UserCollection and add users
        UserCollection userCollection = new UserCollection();
        userCollection.addUser(s1);
        userCollection.addUser(s2);
        userCollection.addUser(s3);
        userCollection.addUser(s4);
        userCollection.addUser(s5);
        userCollection.addUser(p1);
        userCollection.addUser(p2);

        // Print usernames using Iterator
        System.out.println("Registered Users:");
        UserIterator iterator = userCollection.createIterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next().getUsername());
        }

        // Setup planner assignment via facade
        PlannerPool plannerPool = new PlannerPool(Arrays.asList(p1, p2));
        AssignmentEngine engine = new AssignmentEngine();
        PlannerAssignmentFacade facade = new PlannerAssignmentFacade(plannerPool, engine);

        // Loop through students
        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);

        int count = 0;
        for (Student student : students) {
            System.out.println("\n[LOGIN] " + student.getUsername() + " logged in.");
            facade.assignPlannerToStudent(student);

            if (count < 1) {
                System.out.println("[USERNAME CHANGE] for " + student.getUsername());

                student.setUsername(student.getUsername() + "1");
                System.out.println("Change username to: " + student.getUsername());
                student.setUsername(student.getUsername() + "2");
                System.out.println("Change username to: " + student.getUsername());
                student.setUsername(student.getUsername() + "3");
                System.out.println("Change username to: " + student.getUsername());

                System.out.println("Current username: " + student.getUsername());
                System.out.println("Undoing...");
                student.undoUsername();
                System.out.println("After undo: " + student.getUsername());

                System.out.println("Redoing...");
                student.redoUsername();
                System.out.println("After redo: " + student.getUsername());

                student.printUsernameHistory();
            }

            count++;
        }

        
        StudyPlanAbstractFactory factory = new PomodoroAbstractFactory();
        Duration duration = new ShortDuration();
        StudyPlan newPlan = factory.createStudyPlan(duration);
        p2.makePlan(newPlan);
        
        StudyPlanAbstractFactory factory2 = new DeepWorkAbstractFactory();
        Duration duration2 = new LongDuration();
        StudyPlan newPlan2 = factory.createStudyPlan(duration);
        p1.makePlan(newPlan2);
    }
}
