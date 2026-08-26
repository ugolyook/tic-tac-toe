import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrintCoursesForStudent {
    private final Map<Integer, String> students;
    private final Map<Integer, Course> courses;
    private final Map<Integer, List<Integer>> schedule;

    public PrintCoursesForStudent(Map<Integer, String> students,
                                  Map<Integer, Course> courses,
                                  Map<Integer, List<Integer>> schedule) {
        this.students = students;
        this.courses = courses;
        this.schedule = schedule;
    }

    public List<Course> getCoursesForStudentFromDate(int studentId, String date) {
        List<Course> result = new ArrayList<>();

        if (!students.containsKey(studentId)) {
            System.out.println("This student was not found!");
            return result;
        }

        List<Integer> courseIds = schedule.get(studentId);
        if (courseIds == null) {
            return result;
        }

        for (int courseId : courseIds) {
            Course course = courses.get(courseId);
            if (course != null && course.getStartDate().compareTo(date) >= 0) {
                result.add(course);
            }
        }

        return result;
    }
}
