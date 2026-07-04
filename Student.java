import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("%-8d %-20s %-8d %-20s %.2f",
                id, name, age, course, marks);
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + course + "," + marks;
    }

    public static Student fromFileString(String line) {
        String[] data = line.split(",");
        return new Student(
                Integer.parseInt(data[0]),
                data[1],
                Integer.parseInt(data[2]),
                data[3],
                Double.parseDouble(data[4]));
    }
}
