package org.projedata.desafio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador");
        Employee employee2 = new Employee("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador");
        Employee employee3 = new Employee("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador");
        Employee employee4 = new Employee("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor");
        Employee employee5 = new Employee("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"),
                "Recepcionista");
        Employee employee6 = new Employee("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador");
        Employee employee7 = new Employee("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador");
        Employee employee8 = new Employee("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente");
        Employee employee9 = new Employee("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista");
        Employee employee10 = new Employee("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente");

        ArrayList<Employee> listEmployees = new ArrayList<Employee>();
        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);
        listEmployees.add(employee5);
        listEmployees.add(employee6);
        listEmployees.add(employee7);
        listEmployees.add(employee8);
        listEmployees.add(employee9);
        listEmployees.add(employee10);

        listEmployees.removeIf(employee -> employee.getName().equals("João"));

        System.out.println("\u001b[1mLista de funcionários: \u001b[m");
        listEmployees.forEach(employee -> System.out.println(employee));
        System.out.println("-----------------------------------------------------------------------------------------------");

        for(Employee employee : listEmployees){
            employee.increaseSalary(10);
        }

        System.out.println("\u001b[1mLista de funcionários atualizada após aumento de salário: \u001b[m");
        listEmployees.forEach(employee -> System.out.println(employee));
        System.out.println("-----------------------------------------------------------------------------------------------");

        Map<String, List<Employee>> employeesByRole = listEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));

        System.out.println("\u001b[1mLista de funcionários agrupados por função: \u001b[m");

        employeesByRole.forEach((role, employees) -> {
            System.out.println("\u001b[1mFunção: \u001b[m" + role);
            employees.forEach(employee -> System.out.println(employee));
            System.out.println("-----------------------------------------------------------------------------------------------");
        });

        System.out.println("\u001b[1mFuncionários que fazem aniversário nos meses 10 e 12: \u001b[m");
        listEmployees.stream()
                .filter(employee -> employee.getBirthdate().getMonthValue() == 10 || employee.getBirthdate().getMonthValue() == 12)
                .forEach(employee -> System.out.println(employee));

        System.out.println("-----------------------------------------------------------------------------------------------");

        Optional<Employee> oldestEmployee = listEmployees.stream()
                .max(Comparator.comparing(employee -> Period.between(employee.getBirthdate(), LocalDate.now()).getYears()));

        if (oldestEmployee.isPresent()) {
            int age = Period.between(oldestEmployee.get().getBirthdate(), LocalDate.now()).getYears();
            System.out.println("\u001b[1mFuncionário com a maior idade: \u001b[m");
            System.out.println("Nome: " + oldestEmployee.get().getName() + ", Idade: " + age);
        }

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("\u001b[1mLista de funcionários por ordem alfabética: \u001b[m");
        listEmployees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(employee -> System.out.println(employee));

        System.out.println("-----------------------------------------------------------------------------------------------");
        BigDecimal totalSalary = listEmployees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("\u001b[1mTotal salários: \u001b[m" + numberFormat.format(totalSalary));

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("\u001b[1mQuantidade de salários mínimos recebidos por cada funcionário: \u001b[m");
        BigDecimal minimumSalary = new BigDecimal("1212");
        listEmployees.forEach(employee -> System.out.println("Nome: " + employee.getName() + ", Salários mínimos: " + employee.getSalary().divide(minimumSalary, 2, RoundingMode.HALF_UP)));
    }
}
