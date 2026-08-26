public class Course {
    private final String name;
    private final String startDate;

    Course(String name, String startDate) {
        this.startDate = startDate;
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
    }
}
