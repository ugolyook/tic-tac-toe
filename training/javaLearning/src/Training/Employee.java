package Training;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee id: " + id + " name: " + name + " salary: " + salary + " department: " + department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(salary, employee.salary)
                == 0 && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, department);
    }
}
