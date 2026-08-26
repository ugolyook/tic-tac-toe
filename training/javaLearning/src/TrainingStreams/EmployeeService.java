package TrainingStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    public static List<Employee> filter(List<Employee> employees, EmployeePredicate predicate){
        return employees.stream().filter(predicate::test).collect(Collectors.toList());
    }

    public static List<Employee> nameSort(List<Employee> employees){
        List<Employee> sorted = new ArrayList<>(employees);
        sorted.sort(Comparator.comparing(Employee::getName));
        return sorted;
    }

    public static List<Employee> sortBySalary(List<Employee> employees){
       List<Employee> sorted = new ArrayList<>(employees);
       sorted.sort(Comparator.comparing(Employee::getSalary));
       return sorted;
    }
}

