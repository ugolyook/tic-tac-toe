package com.sveta.exercise.API.secondTask;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TaskDto {
    private final String id;
    private final String title;
    private final TaskType type;
    private final LocalDate createdOn;
    private final Set<String> tags = new HashSet<>();

    public TaskDto(String id, String title, TaskType type, LocalDate createdOn, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", createdOn=" + createdOn +
                ", tags=" + tags +
                '}';
    }
}
