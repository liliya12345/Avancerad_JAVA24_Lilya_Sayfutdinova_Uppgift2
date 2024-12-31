package org.example.repo;

import org.example.model.Assessment;
import org.example.model.Student;
import org.example.service.StudentService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private static StudentRepo instance;

    private StudentRepo() {
    }

    public static StudentRepo getInstance() {
        if (instance == null) {
            instance = new StudentRepo();
        }
        return instance;
    }

    public int findMaxStudentId() {
        return findAllStudents().stream()
                .map(Student::getId)
                .max(Integer::compareTo)
                .orElse(0);


    }
    public  void saveStudent(Student student) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/student.txt",true)) {
           String out= student.getId()+";"+student.getFirstName()+";"+student.getLastName();
           fileWriter.write(out);
           fileWriter.write("\n");
           fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> findAllStudents() {
        List<Student> listOfStudents = new ArrayList<>();
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/student.txt"))){
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                List<Assessment> assessmentByStudentId = AssessmentRepo.getInstance().findAssessmentByStudentId(Integer.parseInt(split[0]));
                Student student = new Student(Integer.parseInt(split[0]), split[1], split[2], assessmentByStudentId);
                listOfStudents.add(student);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfStudents;
    }

}
