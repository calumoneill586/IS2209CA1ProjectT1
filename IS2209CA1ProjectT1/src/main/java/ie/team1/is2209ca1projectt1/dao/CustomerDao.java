
package ie.team1.is2209ca1projectt1.dao;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


//Code adapted from: https://www.javaguides.net/2019/07/login-form-using-javafx-with-mysql-database.html 

public class CustomerDao {
    private static final String select_query = "SELECT * FROM customer WHERE username = ? and password = ?";
    private static final String insert_query = "INSERT INTO customer (name,addressline1,addressline2,creditcardno,phoneno,allergies,username,password) VALUES(?,?,?,?,?,?,?,?)";
    private static final String update_query = "UPDATE customer (name,addressline1,addressline2,creditcardno,phoneno,allergies,username,password where id = ? \") VALUES (?,?,?,?,?,?,?,?,)";
   
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
   
    public Customer getCustomer(String username, String password) {
        
        Customer customer = new Customer();
        
        try (Connection connection = DriverManager
            .getConnection(connectionString, "username", "password");

            PreparedStatement preparedStatement = connection.prepareStatement(select_query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddressLine1(resultSet.getString("addressline1"));
                customer.setAddressLine2(resultSet.getString("addressline2"));
                customer.setCreditCardNo(resultSet.getString("creditcardno"));
                customer.setPhoneNo(resultSet.getString("phoneno"));
                customer.setAllergies(resultSet.getString("allergies"));
                customer.setUsername(username);
                customer.setPassword(password);
              
                
            }
          } catch (SQLException e) {
                printSQLException(e);
        }
        return customer;
    }
   //Insert new customer into database
   public static void insertRecord(String name, String addressline1, String addressline2, String creditcardno, String phoneno, String allergies, String username, String password) throws SQLException {         
       

       try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");
            PreparedStatement preparedStatement = conn.prepareStatement(insert_query)) {
          
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, addressline1);
            preparedStatement.setString(3, addressline2);
            preparedStatement.setString(4, creditcardno);
            preparedStatement.setString(5, phoneno);
            preparedStatement.setString(6, allergies);  
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);
            
            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); 

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
     }
   }
   
    public static void updateRecord(String name, String addressline1, String addressline2, String creditcardno, String phoneno, String allergies, String username, String password) throws SQLException {         
     try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");
            PreparedStatement preparedStatement = conn.prepareStatement(update_query)) {
          
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, addressline1);
            preparedStatement.setString(3, addressline2);
            preparedStatement.setString(4, creditcardno);
            preparedStatement.setString(5, phoneno);
            preparedStatement.setString(6, allergies);  
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);
            
            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); 

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
     }
  }
    
    public ObservableList<Customer> getCustomers() { 
         ObservableList<Customer>customers =  FXCollections.observableArrayList();
         try {

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int Id = rs.getInt("INT");
                String name = rs.getString("NAME");
                String addressline1 = rs.getString("ADDRESSLINE1");
                String addressline2 = rs.getString("ADDRESSLINE2");
                String creditcardno = rs.getString("CREDITCARDNO");
                String phoneno = rs.getString("PHONENO");
                String allergies = rs.getString("ALLERGIES");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                
                Customer customer = new Customer(Id, name,addressline1,addressline2,creditcardno,phoneno,allergies,username,password);
                customers.add(customer);
                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return customers;

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
 