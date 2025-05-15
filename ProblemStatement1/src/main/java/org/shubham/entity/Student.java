package org.shubham.entity;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private List<Integer> marks;

    public Student(String course, String email, int id, List<Integer> marks, String name) {
        this.course = course;
        this.email = email;
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course='" + course + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                '}';
    }
}
