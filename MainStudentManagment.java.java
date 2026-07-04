import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagement sm = new StudentManagement();

        while (true) {

            System.out.println("\n====== STUDENT MANAGEMENT SYSTEM ======");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice;

            try{
                choice=Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Invalid Input");
                continue;
            }

            switch(choice){

                case 1:

                    try{

                        System.out.print("Enter ID : ");
                        int id=Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name : ");
                        String name=sc.nextLine();

                        System.out.print("Enter Age : ");
                        int age=Integer.parseInt(sc.nextLine());

                        if(age<=0){
                            System.out.println("Invalid Age");
                            break;
                        }

                        System.out.print("Enter Course : ");
                        String course=sc.nextLine();

                        System.out.print("Enter Marks : ");
                        double marks=Double.parseDouble(sc.nextLine());

                        if(marks<0||marks>100){
                            System.out.println("Marks must be between 0-100");
                            break;
                        }

                        sm.addStudent(new Student(id,name,age,course,marks));

                    }catch(Exception e){

                        System.out.println("Invalid Input.");

                    }

                    break;

                case 2:

                    sm.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID : ");

                    int sid=Integer.parseInt(sc.nextLine());

                    Student s=sm.searchStudent(sid);

                    if(s==null)
                        System.out.println("Student Not Found");
                    else{
                        System.out.println("-------------------------------------------");
                        System.out.printf("%-8s %-20s %-8s %-20s %s\n",
                                "ID","NAME","AGE","COURSE","MARKS");
                        System.out.println("-------------------------------------------");
                        System.out.println(s);
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID : ");

                    sm.updateStudent(Integer.parseInt(sc.nextLine()),sc);

                    break;

                case 5:

                    System.out.print("Enter Student ID : ");

                    sm.deleteStudent(Integer.parseInt(sc.nextLine()));

                    break;

                case 6:

                    System.out.println("Thank You.");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}