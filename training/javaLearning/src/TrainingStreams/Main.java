package TrainingStreams;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public void main(String[] args) {
        Employee employee1 = new Employee(1, "Steve", 2000, "IT");
        Employee employee2 = new Employee(2, "Nolan", 1000, "HR");
        Employee employee3 = new Employee(3, "Alex", 3500, "Finance");
        Employee employee4 = new Employee(4, "Jack", 500, "Economic");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        List<Employee> itEmployee = EmployeeService.filter(employees,
                e -> "IT".equals(e.getDepartment())
        );

        List<Employee> highSalary = EmployeeService.filter(employees,
                e -> e.getSalary() > 1000
        );

        List<Employee> nameStartsWithA = EmployeeService.filter(employees,
                e -> e.getName().startsWith("A")
        );

        System.out.println("Employee: ");
        itEmployee.forEach(System.out::println);
        highSalary.forEach(System.out::println);
        nameStartsWithA.forEach(System.out::println);

        List<Employee> naturalOrder = EmployeeService.nameSort(employees);
        List<Employee> salarySort = EmployeeService.sortBySalary(employees);

        System.out.println("Sorted by natural order: ");
        naturalOrder.forEach(System.out::println);
        System.out.println("sorted by salary: ");
        salarySort.forEach(System.out::println);
    }
}
