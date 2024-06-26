package org.projedata.desafio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Employee extends Person {
    private BigDecimal salary;
    private String role;

    public Employee(String name, LocalDate birthdate, BigDecimal salary, String role) {
        super(name, birthdate);
        this.salary = salary;
        this.role = role;
    }

    public void increaseSalary(int percentage) {
        BigDecimal increase = this.salary.multiply(new BigDecimal(percentage).divide(new BigDecimal("100")));
        this.salary = this.salary.add(increase);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);

        return "Nome: " + super.getName() +
                ", Data nascimento: " + formatter.format(super.getBirthdate()) +
                ", Salário: " + numberFormat.format(salary) +
                ", Função: '" + role + '\'';
    }
}
