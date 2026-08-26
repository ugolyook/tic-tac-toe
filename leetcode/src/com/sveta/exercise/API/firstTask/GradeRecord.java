package com.sveta.exercise.API.firstTask;

public class GradeRecord {
    private final String subject;
    private final String studentName;
    private final int grade;

    public GradeRecord(String subject, String studentName, int grade) {
        this.subject = subject;
        this.studentName = studentName;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getGrade() {
        return grade;
    }
}
