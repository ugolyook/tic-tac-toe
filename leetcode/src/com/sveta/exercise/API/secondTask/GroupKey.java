package com.sveta.exercise.API.secondTask;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class GroupKey {

    private final TaskType type;
    private final LocalDate createdOn;
    private final int year;
    private final Month month;

    public GroupKey( Task task) {
        this.type = task.getType();
        this.createdOn = task.getCreatedOn();
        this.year = task.getCreatedOn().getYear();
        this.month = task.getCreatedOn().getMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GroupKey groupKey = (GroupKey) o;
        return year == groupKey.year && type == groupKey.type && Objects.equals(createdOn, groupKey.createdOn) && month == groupKey.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, createdOn, year, month);
    }

    @Override
    public String toString() {
        return "GroupKey{" +
                "type=" + type +
                ", createdOn=" + createdOn +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
