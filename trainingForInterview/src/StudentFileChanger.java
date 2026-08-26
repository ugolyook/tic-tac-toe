import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentFileChanger {
    String studentFile = "student.csv";
    String courseFile = "courses.csv";
    String scheduleFile = "schedule.csv";

    public Map<Integer, String> readStudents() throws IOException {
        Map<Integer, String> map = new HashMap<>();
        int lineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(studentFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) {
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length == 2) {
                    map.put(Integer.valueOf(parts[0].trim()), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<Integer, Course> readCourse() {
        Map<Integer, Course> map = new HashMap<>();
        int lineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(courseFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) {
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    Course course = new Course(parts[1].trim(), parts[2].trim());
                    map.put(id, course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<Integer, List<Integer>> readSchedule() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int lineNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(scheduleFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) {
                    continue;
                }
                String[] parts = line.split(";");
                int studentId = Integer.parseInt(parts[0].trim());
                int courseId = Integer.parseInt(parts[1].trim());
                List<Integer> courses = map.get(studentId);
                if (courses == null) {
                    courses = new ArrayList<>();
                    map.put(studentId, courses);
                }
                courses.add(courseId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
