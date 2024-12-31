package org.example.service;

import org.example.model.Assessment;
import org.example.model.Mark;
import org.example.model.Subject;
import org.example.repo.AssessmentRepo;

import java.util.List;

public class AssessmentService {
    private static AssessmentService instance;

    public AssessmentService() {
    }
    public static  AssessmentService getInstance() {
        if (instance == null) {
            instance = new AssessmentService();
        }
        return instance;
    }

    public List<Subject> getListSubject(){

        return List.of(Subject.values());
    }
    public List<Mark> getListMark(){
        return List.of(Mark.values());
    }
    public void setAssessment(Assessment assessment){
        int maxAssessmentId = AssessmentRepo.getInstance().findMaxAssessmentId();
        assessment.setId(maxAssessmentId);
        AssessmentRepo.getInstance().saveAssessment(assessment);


    }

}
