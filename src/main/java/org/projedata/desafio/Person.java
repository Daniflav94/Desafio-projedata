package org.projedata.desafio;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected LocalDate birthdate;

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
