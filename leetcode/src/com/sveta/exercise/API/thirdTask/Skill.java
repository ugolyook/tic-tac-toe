package com.sveta.exercise.API.thirdTask;

public class Skill {
    private String name;

    private long knownPercentage;

    public Skill(String name, long knownPercentage) {
        this.name = name;
        this.knownPercentage = knownPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getKnownPercentage() {
        return knownPercentage;
    }

    public void setKnownPercentage(long knownPercentage) {
        this.knownPercentage = knownPercentage;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", knownPercentage=" + knownPercentage +
                '}';
    }
}
