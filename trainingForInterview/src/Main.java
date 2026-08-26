import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public void main(String[] args) throws IOException {
        StudentFileWriter writer = new StudentFileWriter();
        writer.coursesWriter();
        writer.studentWriter();
        writer.schedule();

        StudentFileChanger changer = new StudentFileChanger();
        Map<Integer, String> student = changer.readStudents();
        Map<Integer, Course> course = changer.readCourse();
        Map<Integer, List<Integer>> schedule = changer.readSchedule();

        PrintCoursesForStudent printer = new PrintCoursesForStudent(student, course, schedule);
        int studentId = 1134;
        String date = "2026-06-18";

        List<Course> result = printer.getCoursesForStudentFromDate(studentId, date);
        if (result.isEmpty()) {
            System.out.println("Student have 0 course");
        }  else {
            for (Course c : result) {
                System.out.println("Course: " + c.getName());
            }
        }
    }
}
