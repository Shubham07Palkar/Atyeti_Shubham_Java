package org.shubham.repository;

import org.shubham.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void updateStudent(int id, Student updatedStudent);
    void deleteStudent(int id);
    List<Student> getAllStudents();

}
