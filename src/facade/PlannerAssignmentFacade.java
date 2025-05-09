package facade;

import model.PersonalPlanner;
import model.Student;

public class PlannerAssignmentFacade {
    private PlannerPool plannerPool;
    private AssignmentEngine engine;

    public PlannerAssignmentFacade(PlannerPool plannerPool, AssignmentEngine engine) {
        this.plannerPool = plannerPool;
        this.engine = engine;
    }

    public void assignPlannerToStudent(Student student) {
        PersonalPlanner planner = engine.selectRandomPlanner(plannerPool.getPlanners());

        if (planner != null) {
            // Only attach, do NOT create plan here
            planner.assignStudent(student); // we'll add this method below
            System.out.println("Assigned planner " + planner.getUsername() + " to student " + student.getUsername());
        }
    }
}
