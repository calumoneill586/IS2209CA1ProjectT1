
package ie.team1.is2209ca1projectt1.dao;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//Code adapted from: https://www.javaguides.net/2019/07/login-form-using-javafx-with-mysql-database.html 

public class CustomerDao {
    private static final String database_url = "jdbc:derby://localhost:1527/pizzadatabase";
    private static final String database_username = "username";
    private static final String database_password = "password";
    private static final String select_query = "SELECT * FROM customer WHERE username = ? and password = ?";
    private static final String insert_query = "INSERT INTO customer (name,addressline1,addressline2,creditcardno,phoneno,allergies,username,password)";

    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public CustomerDao() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver"); conn = DriverManager.getConnection(connectionString, "username", "password");
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    //Validation for Login Page with Select Query
    public boolean validate(String username, String password) throws SQLException {
            try (Connection connection = DriverManager
            .getConnection(connectionString, "username", "password");

            PreparedStatement preparedStatement = connection.prepareStatement(select_query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true; 
            }
          } catch (SQLException e) {
                printSQLException(e);
        }
        return false;
    }
   
   //Insert new customer into database
   public static void insertRecord(String name, String addressline1, String addressline2, String creditcardno, String phoneno, String allergies, String username, String password) throws SQLException {         
       try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");
           
            PreparedStatement preparedStatement = conn.prepareStatement(insert_query)) {
            preparedStatement.setString(1, "name");
            preparedStatement.setString(2, "addressline1");
            preparedStatement.setString(3, "addressline2");
            preparedStatement.setString(4, "creditcardno");
            preparedStatement.setString(5, "phoneno");
            preparedStatement.setString(6, "allergies");  
            preparedStatement.setString(7, "username");
            preparedStatement.setString(8, "password");
            
            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); 

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
     }
   }
   
    
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
 