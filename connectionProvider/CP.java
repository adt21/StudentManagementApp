package connectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;
public class CP {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String username = "root";
            String password = "Bindu@009";
            //String password = "";
            String url = "jdbc:mysql://localhost:3306/project";
            con = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
           e.printStackTrace();
        }
        return con;
        
    }
}
