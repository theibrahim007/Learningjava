import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTest {
    public static void main(String[] args) {
        try {
            // Method 1 (Old Way) - Wake up the translator
            Class.forName("com.mysql.cj.jdbc.Driver");

            // The address of your MySQL
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "root123"; // <-- change this!

            // Open the bridge
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected successfully! 🎉");
            con.close();

        } catch (Exception e) {
            System.out.println("Something went wrong:");
            e.printStackTrace();
        }
    }
}

//ask what to do next and also there is two methods of doing this shit