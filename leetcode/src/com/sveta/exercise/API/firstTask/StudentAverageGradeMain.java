//Задача 4: На основании моделей из первой задачи сделать алгоритм,
// который по итогу будет показывать списки студентов с их оценки по каждому предмету.
// То есть грубо говоря, каждая строка  отчёта будет включать в себя название предмета,
// а дальше список имён студентов с их оценками. Например:
//Math: (Steve: 7, Andrew: 8)
//Physics: (Andrew: 9, Dan: 8)

package com.sveta.exercise.API.firstTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StudentAverageGradeMain {
    public static void main(String[] args) {
        String subject = "Math";
        List<Student> students = createNewStudents();

        OptionalDouble mathAverage = students.stream()
                .filter(student -> student.rating.containsKey(subject))
                .mapToInt(student -> student.rating.get(subject))
                .average();

        System.out.println(mathAverage);
        System.out.println("new task: ");

        Map<String, Map<String, Integer>> records = students.stream()
                .flatMap(student -> student.getRating().entrySet().stream()
                        .map(entry -> new GradeRecord(
                                entry.getKey(),
                                student.getName(),
                                entry.getValue()
                        ))
                )
                .collect(Collectors.groupingBy(
                        GradeRecord::getSubject,
                        Collectors.toMap(
                                GradeRecord::getStudentName,
                                GradeRecord::getGrade
                        )
                ));

        records.forEach((subjectName, stringIntegerMap) -> {
            System.out.println(
                    stringIntegerMap.entrySet().stream()
                            .map(e -> e.getKey() + " " + e.getValue())
                            .collect(Collectors.joining(", ", subjectName + ":(", ")"))
            );
        });

    }

    private static List<Student> createNewStudents() {
        Student student1 = new Student("Lana");
        student1.rate("Math", 9);
        student1.rate("Science", 5);
        student1.rate("English", 7);

        Student student2 = new Student("Gorge");
        student2.rate("Math", 9);
        student2.rate("Science", 9);
        student2.rate("English", 10);

        Student student3 = new Student("Kimmi");
        student3.rate("Math", 5);
        student3.rate("Science", 6);
        student3.rate("English", 9);

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }
}
