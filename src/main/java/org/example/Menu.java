package org.example;


import org.example.model.Assessment;
import org.example.model.Mark;
import org.example.model.Student;
import org.example.model.Subject;
import org.example.service.AssessmentService;
import org.example.service.StudentService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    MenuProgram menuProgram = new MenuProgram();


    //  En metod som startar programmet och kommunicera med användare
    public void startMenu() {


        menuProgram.menuProgram();
        int choice = -1;
        //Går i loop tills knapp 0 trycks in.
        do {
            //Här visas alla val av menu

            Scanner scanner = new Scanner(System.in);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");

                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("Add firstname of student");
                    String firstName = scanner.next();
                    System.out.println("Add lastname of student");
                    String lastName = scanner.next();
                    Student student = new Student(firstName, lastName);
                    StudentService.getInstance().addStudent(student);
                    System.out.println("Student added");

                }
                case 2 -> {
                      StudentService.getInstance().getAllStudents().forEach(System.out::println);


                }
                case 3 -> {
                 //   StudentService.getInstance().getAllStudents().forEach(System.out::println);
                    System.out.println("Enter student id");
                  try{
                      int id = scanner.nextInt();
                      Student student = StudentService.getInstance().getStudentById(id);
                      if(student != null) {
                          System.out.println(student);
                      }else System.out.println("Student not found");

                  }catch (InputMismatchException e) {
                      System.out.println("Invalid input");
                  }



                }
                case 4 -> {
                    System.out.println("Enter id student for set assignment");
                    try {
                        int id = scanner.nextInt();
                        Student student = StudentService.getInstance().getStudentById(id);
                        if(student != null) {
                            System.out.println(student);
                            System.out.println("Enter number of subject");
                            List<Subject> listSubject = AssessmentService.getInstance().getListSubject();
                            for (int i = 0; i <listSubject.size() ; i++) {
                                System.out.println(i+1 +"."+listSubject.get(i));
                            }
                            int subjectNum = scanner.nextInt();
                            Subject subject = listSubject.get(subjectNum-1);
                            System.out.println("Enter the subject of assignment");
                            List<Mark> listMark = AssessmentService.getInstance().getListMark();
                            for (int i = 0; i <listMark.size() ; i++) {
                                System.out.println(listMark.get(i));
                            }
                            System.out.println("Enter the mark");
                            String mark = scanner.next();
                            Assessment assessment = new Assessment(subject,Mark.valueOf(mark), student.getId());
                            AssessmentService.getInstance().setAssessment(assessment);
                        }else System.out.println("Student not found");

                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Invalid input number of subject");
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Invalid input of mark");
                    }



                }default -> {
                    System.out.println("Invalid choice");
                }


            }


            if (choice != 0) {

                menuProgram.menuProgram();
            }

        } while (choice != 0);
        System.out.println("bye");
    }
}

