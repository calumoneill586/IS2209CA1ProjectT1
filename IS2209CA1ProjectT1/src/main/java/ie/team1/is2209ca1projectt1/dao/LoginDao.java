
package ie.team1.is2209ca1projectt1.dao;
import java.sql.*;


//Code adapted from: https://www.javaguides.net/2019/07/login-form-using-javafx-with-mysql-database.html 

public class LoginDao {
    private static final String database_url = "jdbc:derby://localhost:1527/pizzadatabase";
    private static final String database_username = "username";
    private static final String database_password = "password";
    private static final String select_query = "SELECT * FROM customer WHERE username = ? and password = ?";
    
     public boolean validate(String username, String password) throws SQLException {
            try (Connection connection = DriverManager
            .getConnection(database_url, database_username, database_password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(select_query)) {
            preparedStatement.setString(1, username); //WHAT IS WRONNGGGG?
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true; 
            }
          } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;
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
