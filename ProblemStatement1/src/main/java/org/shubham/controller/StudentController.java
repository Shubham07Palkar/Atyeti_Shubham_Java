package org.shubham.controller;

import org.shubham.Service.MarksAnalysisService;
import org.shubham.Service.StudentServiceImpl;
import org.shubham.entity.Student;
import org.shubham.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentServiceImpl studentService = new StudentServiceImpl();
    private final Scanner sc = new Scanner(System.in);
    List<Student> students = StudentServiceImpl.students;
    private final MarksAnalysisService marksAnalysisService = new MarksAnalysisService();

    public void start() {
        while (true) {
            System.out.println("\n ==== Students Performance Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Top 3 Performers");
            System.out.println("5. View Failed Students");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Sort Students by Id");
            System.out.println("8. Sort Students by Marks");
            System.out.println("9. Save & Exit");
            System.out.println("Choose an Option from Below");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudents();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                marksAnalysisService.findTop3(students).forEach(System.out::println);
                break;

                case 5:
                    marksAnalysisService.filterFailed(students).forEach(System.out::println);
                break;

                case 6:
                    marksAnalysisService.sortByName(students).forEach(System.out::println);
                break;

                case 7:
                    marksAnalysisService.sortById(students).forEach(System.out::println);
                break;

                case 8:
                    marksAnalysisService.sortByMarks(students).forEach(System.out::println);
                break;

                case 9:
                    System.out.println("Saving and Exiting");
                return;


                default:
                    System.out.println("Invalid Input, Try Again");
            }
        }
    }

    public void addStudents() {
        System.out.println("Enter User Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter course name");
        String course = sc.nextLine();
        System.out.println("Enter your Email");
        String email = sc.nextLine();
        System.out.println("Enter list of marks");
        List<Integer> marks = new ArrayList<>();
        for (int i =0;i<5;i++){
            while(!sc.hasNext()){
                sc.next();
            }
            marks.add(sc.nextInt());
        }
        Student student = new Student(course, email, id, marks, name);
        studentService.addStudent(student);
    }

    public void updateStudent() throws StudentNotFoundException{
        try {
            System.out.println("Enter User Id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter your name");
            String name=sc.nextLine();
            System.out.println("Enter course name");
            String course = sc.nextLine();
            System.out.println("Enter your Email");
            String email = sc.nextLine();
            System.out.println("Enter list of marks");
            List<Integer> marks = new ArrayList<>();
            for (int i =0;i<5;i++){
                while(!sc.hasNext()){
                    sc.next();
                }
                marks.add(sc.nextInt());
            }
            Student student = new Student(course, email, id, marks, name);
            studentService.updateStudent(id, student);
        } catch (Exception e) {
            throw new StudentNotFoundException(e.getMessage());
        }
    }

    public void deleteStudent(){
        try {
            System.out.println("Enter User Id");
            int id = sc.nextInt();
            sc.nextLine();
            studentService.deleteStudent(id);
        } catch (Exception e) {
            throw new StudentNotFoundException(e.getMessage());
        }
    }

}
