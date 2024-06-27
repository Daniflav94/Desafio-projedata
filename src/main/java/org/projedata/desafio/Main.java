package org.projedata.desafio;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        ListEmployees listEmployees = new ListEmployees();
        listEmployees.add(new Employee("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        listEmployees.add(new Employee("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"));
        listEmployees.add(new Employee("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"));
        listEmployees.add(new Employee("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));
        listEmployees.add(new Employee("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"),
                "Recepcionista"));
        listEmployees.add(new Employee("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));
        listEmployees.add(new Employee("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));
        listEmployees.add(new Employee("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        listEmployees.add(new Employee("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"));
        listEmployees.add(new Employee("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente"));

        listEmployees.removeByName("João");

        listEmployees.listAll();

        listEmployees.increaseAllSalary();

        listEmployees.groupingByRole();

        listEmployees.findByBirthdateOnMonth10And12();

        listEmployees.findOldestEmployee();

        listEmployees.sortByAlphabeticalOrder();

        listEmployees.getTotalSalary();

        listEmployees.getMinimunSalary();
    }
}
