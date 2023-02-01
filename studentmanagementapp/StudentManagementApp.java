package studentmanagementapp;

import DataAccessObject.StudentDAO;
import entity.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StudentManagementApp {
    
    public static void main(String[] args) throws IOException
    {
    //    Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = 0, id = 0;
        String name = "", phone = "", city = "";
        boolean status = false;
        while(true){
            System.out.println("Hello Welcome to Student Management App!");
            System.out.println("Enter 1 to Display all the Students");
            System.out.println("Enter 2 to Insert all the Students");
            System.out.println("Enter 3 to Update all the Students");
            System.out.println("Enter 4 to Delete all the Students");
            System.out.println("Enter 5 to Exit");
            op = Integer.parseInt(br.readLine());
            if(op == 1){
                StudentDAO.displayStudent();
            }
            else if(op == 2){
                //insert......
                System.out.println("Enter the name of the Student");
                
                name = br.readLine();
                System.out.println("Enter the Phone number of the Student");
                
                phone = br.readLine();
                System.out.println("Enter the City of the Student");
                
                city = br.readLine();
                Student st = new Student(name, phone, city);
                status = StudentDAO.insertStudentToDB(st);
                if(status){
                    System.out.println("Success!");
                }
                else{
                    System.out.println("Something went wrong!! Please try again.");
                }
                
            }
            else if(op == 3){
                //update.....
                System.out.println("We suggest you to kindly display all the students for confirming the student id, whom to be updated!");
                System.out.println("Enter the Student Id");
                id = Integer.parseInt(br.readLine());;
                System.out.println("Enter 1 to Update Name");
                System.out.println("Enter 2 to Update Phone");
                System.out.println("Enter 3 to Update City");
                op = Integer.parseInt(br.readLine());
                
                if(op == 1){
                    //update name.....
                    System.out.println("Enter the new Name");
                    
                    name = br.readLine();
                    status = StudentDAO.updateStudent(id, op, name);
                
                if(status){
                    System.out.println("Success!");
                }
                else{
                    System.out.println("Something went wrong!! Please try again.");
                }
            }
                else if(op == 2){
                    //phone update......
                    System.out.println("Enter the new Phone number");
                    phone = br.readLine();
                    status = StudentDAO.updateStudent(id, op, phone);
                }
                else if(op == 3){
                    //city update......
                    System.out.println("Enter the new City");
                    
                    city = br.readLine();
                    status = StudentDAO.updateStudent(id, op, city);
                    if(status){
                    System.out.println("Success!");
                }
                    else{
                    System.out.println("Something went wrong!! Please try again.");
                }
                }
                else{
                    System.out.println("Please enter the right option! and try again");
                }
            }
            else if(op == 4){
                //delete...
                System.out.println("We suggest you to kindly display all the students for confirming the student id, whom to be Deleted!!");
                System.out.println("Enter the Student Id");
                id = Integer.parseInt(br.readLine());
                status = StudentDAO.deleteStudent(id);
                if(status){
                    System.out.println("Success!");
                }
                else{
                    System.out.println("Something went wrong!! Please try again.");
                }
                
            }
            else if(op == 5){
                System.out.println("Thanks for using our Application! Hope you enjoyed!! See you");
                break;
            }
        }
    }
    
}