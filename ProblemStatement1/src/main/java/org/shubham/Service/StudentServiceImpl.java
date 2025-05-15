package org.shubham.Service;

import org.shubham.entity.Student;
import org.shubham.exception.StudentNotFoundException;
import org.shubham.fileHandler.JsonFileHandler;
import org.shubham.repository.StudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    public static List<Student> students = new ArrayList<>();
    JsonFileHandler jsonFileHandler = new JsonFileHandler();

    public StudentServiceImpl(){
        students = jsonFileHandler.loadStudents();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        jsonFileHandler.saveStudent(students);
    }

    @Override
    public void updateStudent(int id, Student updatedStudent) {
        Student student = students.stream()
                .filter(x -> x.getId() == id).findFirst().orElse(null);

        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }

        student.setCourse(updatedStudent.getCourse());
        student.setEmail(updatedStudent.getEmail());
        student.setMarks(updatedStudent.getMarks());
        student.setName(updatedStudent.getName());
        jsonFileHandler.saveStudent(students);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = students.stream()
                .filter(x -> x.getId() == id).findFirst().orElse(null);
        students.remove(student);
        jsonFileHandler.saveStudent(students);
    }

    public Student getById(int id){
        Student student = students.stream()
                .filter(x -> x.getId() == id).findFirst().orElse(null);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}
