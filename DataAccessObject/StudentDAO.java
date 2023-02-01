package DataAccessObject;

import connectionProvider.CP;
import entity.Student;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class StudentDAO {
    public static boolean insertStudentToDB(Student student){
        boolean status = false;
        try
        {
            Connection con = CP.getConnection();
        
            DatabaseMetaData meta = con.getMetaData();
            ResultSet set = meta.getTables(null, null, "student", null);
            
            if(set.next()){
                //table exist..
                //now insert....
                String insertQuery = "INSERT INTO Student(Name,Phone,City) values(?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                // PreparedStatement means changes of dynamic value again and again
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getPhone());
                preparedStatement.setString(3, student.getCity());
                preparedStatement.executeUpdate();
            }
            else{
                //creating table
                String createTable = "create table student(Id int auto_increment,Name varchar(200),Phone varchar(20),City varchar(100),primary key(Id))";
                Statement statement = con.createStatement();
                //createStatement means no value change
                statement.executeUpdate(createTable);
                //now insert...
                String insertQuery = "INSERT INTO Student(Name,Phone,City) values(?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                // PreparedStatement means changes of dynamic value again and again
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getPhone());
                preparedStatement.setString(3, student.getCity());
                preparedStatement.executeUpdate();
                
            }
            status = true;
        }
        catch(Exception e){
           // e.printStackTrace();
           System.out.println("Entry creation failed" + e);
            return status;
        }
        return status;
    }
    public static boolean updateStudent(int Id,int option,String val){
        boolean status = false;
        try
        {
            Connection con = CP.getConnection();
            if(option == 1){
                //update name....
                String query = "Update Student set Name = ? where Id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                // PreparedStatement means changes of dynamic value again and again
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, Id);
                
                preparedStatement.executeUpdate();
            }
            else if(option == 2){
                //update phone number...
                String query = "Update Student set Phone = ? where Id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, Id);
                
                preparedStatement.executeUpdate();
            }
            else{
                //update city...
                 String query = "Update Student set City = ? where Id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, Id);
                
                preparedStatement.executeUpdate();
            }
            status = true;
        }
        catch(Exception e){
            e.printStackTrace();
            return status;
        }
        return status;
    }
    public static boolean deleteStudent(int Id){
        boolean status = false;
        try
        {
            Connection con = CP.getConnection();
            
            String query = "DELETE from student where Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            // PreparedStatement means changes of dynamic value again and again
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
            status = true;
        }
        catch(Exception e){
            e.printStackTrace();
            return status;
        }
        return status;
    }
    public static void displayStudent(){
        try
        {
            Connection con = CP.getConnection();
            String query = "Select * from student";
            Statement statement = con.createStatement(); //createStatement means no value change
            ResultSet set = statement.executeQuery(query);
            //executeQuery means which we fire we expect return something form this
            //but executeupdate doesnot return anything that's why here we use executeQuery
            int c = 0;
            while(set.next()){
                c++;
                System.out.println("Student Id = " + set.getInt(1));
                System.out.println("Student Name = " + set.getString(2));
                System.out.println("Student Phone = " + set.getString(3));
                System.out.println("Student City = " + set.getString(4));
                System.out.println("*****************************************");
            }
            if(c == 0){
                System.out.println("No Data Found!! Please Insert some data first to display");
            }
        }
        catch(Exception e){
             e.printStackTrace();
        }
           
        }  
}
