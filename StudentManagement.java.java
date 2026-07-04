import java.io.*;
import java.util.*;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentManagement() {
        loadStudents();
    }

    public void addStudent(Student student) {

        for(Student s: students){
            if(s.getId()==student.getId()){
                System.out.println("Student ID already exists.");
                return;
            }
        }

        students.add(student);
        saveStudents();
        System.out.println("Student Added Successfully.");
    }

    public void viewStudents(){

        if(students.isEmpty()){
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-8s %-20s %s\n",
                "ID","NAME","AGE","COURSE","MARKS");
        System.out.println("---------------------------------------------------------------");

        for(Student s: students){
            System.out.println(s);
        }
    }

    public Student searchStudent(int id){

        for(Student s: students){
            if(s.getId()==id){
                return s;
            }
        }

        return null;
    }

    public void updateStudent(int id, Scanner sc){

        Student s=searchStudent(id);

        if(s==null){
            System.out.println("Student Not Found.");
            return;
        }

        System.out.print("Enter New Name : ");
        s.setName(sc.nextLine());

        System.out.print("Enter Age : ");
        s.setAge(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter Course : ");
        s.setCourse(sc.nextLine());

        System.out.print("Enter Marks : ");
        s.setMarks(Double.parseDouble(sc.nextLine()));

        saveStudents();

        System.out.println("Student Updated Successfully.");
    }

    public void deleteStudent(int id){

        Student s=searchStudent(id);

        if(s==null){
            System.out.println("Student Not Found.");
            return;
        }

        students.remove(s);

        saveStudents();

        System.out.println("Student Deleted Successfully.");
    }

    private void saveStudents(){

        try(PrintWriter pw=new PrintWriter(new FileWriter(FILE_NAME))){

            for(Student s: students){
                pw.println(s.toFileString());
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void loadStudents(){

        File file=new File(FILE_NAME);

        if(!file.exists())
            return;

        try(BufferedReader br=new BufferedReader(new FileReader(FILE_NAME))){

            String line;

            while((line=br.readLine())!=null){

                students.add(Student.fromFileString(line));

            }

        }catch(IOException e){

            System.out.println(e.getMessage());

        }

    }

}