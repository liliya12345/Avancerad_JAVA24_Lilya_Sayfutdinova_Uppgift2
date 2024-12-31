package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepo;

import java.util.List;

public class StudentService {
    private static StudentService instance;

    private StudentService() {
    }

    public static  StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }
    public void addStudent(Student student) {
        int maxStudentId = StudentRepo.getInstance().findMaxStudentId();
        student.setId(maxStudentId + 1);
        StudentRepo.getInstance().saveStudent(student);

    }

    public List<Student> getAllStudents() {
        return StudentRepo.getInstance().findAllStudents();
    }
    public Student getStudentById(int id) {
        return StudentRepo.getInstance().findAllStudents()
                .stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
}
