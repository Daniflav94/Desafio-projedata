package org.projedata.desafio;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthdate;

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }


}
