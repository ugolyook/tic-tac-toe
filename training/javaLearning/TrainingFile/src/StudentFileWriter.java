import java.io.FileWriter;
import java.io.IOException;

public class StudentFileWriter {
    public void studentWriter() {
        String csvFile = "student.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("id;name\n");
            writer.append("1134;alex\n");
            writer.append("2567;jay\n");
            writer.append("3498;gas\n");
            writer.append("0234;oliver\n");
            writer.append("4521;emma\n");
            writer.append("5678;noah\n");
            writer.append("6789;sophia\n");
            writer.append("7890;mason\n");
            writer.append("8901;isabella\n");
            writer.append("9012;lucas\n");
            writer.append("0123;mia\n");
            writer.append("2345;ethan\n");
            writer.append("3456;charlotte\n");
            writer.append("4567;logan\n");
            writer.append("7891;amelia\n");
            writer.flush();
            System.out.println("csv file was saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void coursesWriter() {
        String csvFile = "courses.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("id;name;course start time\n");
            writer.append("0001;math;2026-06-18\n");
            writer.append("0002;english;2026-06-18\n");
            writer.append("0003;russian;2026-06-18\n");
            writer.append("0004;economic;2026-06-18\n");
            writer.append("0005;physics;2026-06-18\n");
            writer.append("0006;chemistry;2026-06-18\n");
            writer.append("0007;biology;2026-06-18\n");
            writer.append("0008;history;2026-06-18\n");
            writer.append("0009;geography;2026-06-18\n");
            writer.append("0010;programming;2026-06-18\n");
            writer.flush();
            System.out.println("csv file was saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void schedule() {
        String csvFile = "schedule.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("student id; course id\n");
            writer.append("1134;0001\n");
            writer.append("1134;0005\n");
            writer.append("1134;0010\n");
            writer.append("2567;0002\n");
            writer.append("2567;0004\n");
            writer.append("2567;0006\n");
            writer.append("2567;0009\n");
            writer.append("3498;0002\n");
            writer.append("3498;0007\n");
            writer.append("0234;0003\n");
            writer.append("0234;0008\n");
            writer.append("0234;0010\n");
            writer.append("4521;0001\n");
            writer.append("4521;0006\n");
            writer.append("4521;0007\n");
            writer.append("5678;0004\n");
            writer.append("5678;0005\n");
            writer.append("5678;0009\n");
            writer.append("6789;0001\n");
            writer.append("6789;0008\n");
            writer.append("7890;0002\n");
            writer.append("7890;0005\n");
            writer.append("7890;0007\n");
            writer.append("8901;0003\n");
            writer.append("8901;0006\n");
            writer.append("8901;0010\n");
            writer.append("9012;0004\n");
            writer.append("9012;0008\n");
            writer.append("0123;0001\n");
            writer.append("0123;0009\n");
            writer.append("0123;0010\n");
            writer.append("2345;0002\n");
            writer.append("2345;0005\n");
            writer.append("2345;0008\n");
            writer.append("3456;0003\n");
            writer.append("3456;0007\n");
            writer.append("4567;0001\n");
            writer.append("4567;0004\n");
            writer.append("4567;0006\n");
            writer.append("7891;0002\n");
            writer.append("7891;0005\n");
            writer.append("7891;0009\n");
            writer.flush();
            System.out.println("csv file was saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
