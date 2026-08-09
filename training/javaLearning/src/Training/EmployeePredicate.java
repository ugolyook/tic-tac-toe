package Training;

@FunctionalInterface
public interface EmployeePredicate {
    boolean test(Employee e);
}
