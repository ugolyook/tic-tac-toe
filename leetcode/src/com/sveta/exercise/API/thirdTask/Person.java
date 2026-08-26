//Задача 7: Tasks:(Это будут подзадачи, просто так было описано на самом интервью)
//Найти наиболее подходящего человека - например, если кто-то ищет специалиста
// с уровнем владения английским языком более 50%, то нам нужно найти человека, уровень владения которым превышает 50%.
/// / В приведенном выше примере Гнанеш имеет 100% уровень владения английским языком.
////Если ни один из кандидатов не соответствует заданному порогу (случай с каннада в приведенном выше примере),
//// то найти специалиста, который лучше всех остальных, то есть Суреша в приведенном выше случае (40%).
////Система должна вести учет, т.е. если мы забронировали место, оно не должно быть предложено снова.
package com.sveta.exercise.API.thirdTask;

import java.util.Arrays;
import java.util.List;

public class Person {
    private Long personId;

    private String name;

    private List<Skill> skills;

    public Person(Long personId, String name, Skill... skills) {
        this.personId = personId;
        this.name = name;
        this.skills = Arrays.asList(skills);
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return name;
    }
}

