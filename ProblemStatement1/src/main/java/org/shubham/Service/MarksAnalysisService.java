package org.shubham.Service;

import org.shubham.entity.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MarksAnalysisService {
    StudentServiceImpl studentService = new StudentServiceImpl();

//    calculating average for student
    private double calculateAverage(Student student){
        return student.getMarks().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    private double calculateTotal(Student student){
        return student.getMarks().stream()
                .mapToInt(Integer::intValue).sum();
    }

//    finding top3 performers
    public List<Student> findTop3(List<Student> students){
        return students
                .stream().sorted(Comparator.comparingDouble(this::calculateAverage).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Student> filterFailed(List<Student> students){
        return students.stream()
                .filter(s -> calculateAverage(s) < 40)
                .collect(Collectors.toList());
    }


    public List<Student> sortByName(List<Student> students){
        return students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public List<Student> sortByMarks(List<Student> students){
        return students.stream()
                .sorted(Comparator.comparingDouble(this::calculateTotal).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortById(List<Student> students){
        return students.stream()
                .sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
    }

}
