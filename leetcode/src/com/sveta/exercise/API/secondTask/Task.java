//Задача 2: Найдите 5 первых заданий для чтения,
// отсортированных по дате создания и объединить значения поля title в одну строку через запятую.
//Задача 3: Конвертировать из предыдущей задачи Task->TaskDto
//Задача 5: Сделать группировку модели из задачи 2 по любым 4 параметрам

package com.sveta.exercise.API.secondTask;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Task {
    private final String id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private Set<String> tags = new HashSet<>();

    public Task(String title, TaskType type, LocalDate createdOn) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public Task addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public TaskDto toDto() {
        return new TaskDto(
                this.id,
                this.title,
                this.type,
                this.createdOn,
                this.tags
        );
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public String getTitle() {
        return title;
    }

    static void main(String[] args) {
        List<Task> tasks = getTasks();

        System.out.println("Sorted stream by the time of creation: ");
        tasks.stream()
                .sorted(Comparator.comparing(task -> task.createdOn))
                .map(task -> task.title)
                .forEach(System.out::println);

        System.out.println("\nDto stream:");

        tasks.stream()
                .map(Task::toDto)
                .forEach(System.out::println);

        System.out.println("\nGrouped stream:");

        Map<GroupKey, List<Task>> groupKeyListMap = tasks.stream()
                .collect(Collectors.groupingBy(
                        (GroupKey::new)
                ));

        groupKeyListMap.forEach((groupKey, taskList) -> {
                    System.out.println(groupKey + " -> " + taskList.size() + " task");
                    taskList.forEach(task -> System.out.println("  - " + task.getTitle()));
                }
        );
    }

    private static List<Task> getTasks() {
        Task task1 = new Task("Read Version Control with Git book",
                TaskType.READING, LocalDate.of(2015, Month.JULY, 1))
                .addTag("git")
                .addTag("reading")
                .addTag("books");

        Task task2 = new Task("Read Java 8 Lambdas book",
                TaskType.READING, LocalDate.of(2015, Month.JULY, 2))
                .addTag("java8")
                .addTag("reading")
                .addTag("books");

        Task task3 = new Task("Write a mobile application to store my tasks",
                TaskType.CODING, LocalDate.of(2015, Month.JULY, 3))
                .addTag("coding")
                .addTag("mobile");

        Task task4 = new Task("Write a blog on Java 8 Streams",
                TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4))
                .addTag("blogging")
                .addTag("writing")
                .addTag("streams");

        Task task5 = new Task("Read Domain Driven Design book",
                TaskType.READING, LocalDate.of(2015, Month.JULY, 5))
                .addTag("ddd")
                .addTag("books")
                .addTag("reading");

        return Arrays.asList(task1, task2, task3, task4, task5);
    }
}