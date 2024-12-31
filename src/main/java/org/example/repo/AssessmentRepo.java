package org.example.repo;

import org.example.model.Assessment;
import org.example.model.Mark;
import org.example.model.Student;
import org.example.model.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssessmentRepo {
    private static AssessmentRepo instance;

    public AssessmentRepo() {
    }
    public static AssessmentRepo getInstance() {
        if (instance == null) {
            instance = new AssessmentRepo();
        }
        return instance;
    }
    public int findMaxAssessmentId() {
        return findAllAssessment().stream()
                .map(Assessment::getId)
                .max(Integer::compareTo)
                .orElse(0);


    }
    public List<Assessment> findAllAssessment() {
        List<Assessment> listOfAssessment = new ArrayList<>();
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/assessment.txt"))){
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Assessment assessment = new Assessment(Integer.parseInt(split[0]), Subject.valueOf(split[1]), Mark.valueOf(split[2]),Integer.parseInt(split[3]));
                listOfAssessment.add(assessment);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfAssessment;
    }
// metod som sparar data om betyg
    public void saveAssessment(Assessment assessment) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/assessment.txt",true)) {
            String out= assessment.getId()+";"+assessment.getSubject()+";"+assessment.getMark()+";"+assessment.getStudentId();
            fileWriter.write(out);
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//metod som letar  efter  betyg med student Id
    public List<Assessment> findAssessmentByStudentId(int studentId) {
        return findAllAssessment().stream().filter(assessment -> assessment.getStudentId()==studentId).toList();
    }
}
