package org.projedata.desafio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class ListEmployees {
    private List<Employee> listEmployees;

    public ListEmployees() {
        this.listEmployees = new ArrayList<>();
    }

    public void add(String name, LocalDate birthdate, BigDecimal salary, String role){
        listEmployees.add(new Employee(name, birthdate, salary, role));
    }

    public void removeByName(String employeeName){
        listEmployees.removeIf(employee -> employee.getName().equals(employeeName));
    }

    public void listAll() {
        System.out.println("\u001b[1mLista de funcionários: \u001b[m");
        listEmployees.forEach(employee -> System.out.println(employee));
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void increaseAllSalary(){
        for(Employee employee : listEmployees){
            employee.increaseSalary(10);
        }

        System.out.println("\u001b[1mLista de funcionários atualizada após aumento de salário: \u001b[m");
        listEmployees.forEach(employee -> System.out.println(employee));
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void groupingByRole(){
        Map<String, List<Employee>> employeesByRole = listEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));

        System.out.println("\u001b[1mLista de funcionários agrupados por função: \u001b[m");

        employeesByRole.forEach((role, employees) -> {
            System.out.println("\u001b[1mFunção: \u001b[m" + role);
            employees.forEach(employee -> System.out.println(employee));
            System.out.println("-----------------------------------------------------------------------------------------------");
        });
    }

    public void findByBirthdateOnMonth10And12(){
        System.out.println("\u001b[1mFuncionários que fazem aniversário nos meses 10 e 12: \u001b[m");
        listEmployees.stream()
                .filter(employee -> employee.getBirthdate().getMonthValue() == 10 || employee.getBirthdate().getMonthValue() == 12)
                .forEach(employee -> System.out.println(employee));

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void findOldestEmployee(){
        Optional<Employee> oldestEmployee = listEmployees.stream()
                .max(Comparator.comparing(employee -> Period.between(employee.getBirthdate(), LocalDate.now()).getYears()));

        if (oldestEmployee.isPresent()) {
            int age = Period.between(oldestEmployee.get().getBirthdate(), LocalDate.now()).getYears();
            System.out.println("\u001b[1mFuncionário com a maior idade: \u001b[m");
            System.out.println("Nome: " + oldestEmployee.get().getName() + ", Idade: " + age);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void sortByAlphabeticalOrder(){
        System.out.println("\u001b[1mLista de funcionários por ordem alfabética: \u001b[m");
        listEmployees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(employee -> System.out.println(employee));

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void getTotalSalary(){
        BigDecimal totalSalary = listEmployees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("\u001b[1mTotal salários: \u001b[m" + numberFormat.format(totalSalary));

        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void getMinimunSalary(){
        System.out.println("\u001b[1mQuantidade de salários mínimos recebidos por cada funcionário: \u001b[m");
        BigDecimal minimumSalary = new BigDecimal("1212");
        listEmployees.forEach(employee -> System.out.println("Nome: " + employee.getName() + ", Salários mínimos: " + employee.getSalary().divide(minimumSalary, 2, RoundingMode.HALF_UP)));
    }
}
