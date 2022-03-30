
package ie.team1.is2209ca1projectt1.dao;
import java.sql.*;


//Code adapted from: https://www.javaguides.net/2019/07/login-form-using-javafx-with-mysql-database.html 

public class CustomerDao {
    private static final String database_url = "jdbc:derby://localhost:1527/pizzadatabase";
    private static final String database_username = "username";
    private static final String database_password = "password";
    private static final String select_query = "SELECT * FROM customer WHERE username = ? and password = ?";
    private static final String insert_query = "INSERT INTO customer (name, address1,address2,ccNumber,phoneNumber,allergies,username,password)";
    
    
    //Validation for Login Page with Select Query
    public boolean validate(String username, String password) throws SQLException {
            try (Connection connection = DriverManager
            .getConnection(database_url, database_username, database_password);

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
    public void insertRecord(String name,String address1,String address2,String ccNumber,String phoneNumber,String allergies,String username,String password) throws SQLException {  
        try (Connection connection = DriverManager
            .getConnection(database_url, database_username, database_password);
         
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address1);
            preparedStatement.setString(3, address2);
            preparedStatement.setString(4, ccNumber);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, allergies);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);

            System.out.println(preparedStatement);
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            
            printSQLException(e);
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
