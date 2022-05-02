package ie.team1.is2209ca1projectt1.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class OrderDao {

    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    private static final String insert_query = "INSERT INTO orders (CUSTOMERID, PAYMETHOD, GETMETHOD, REQUEST, TOTAL, NOINGREDIENT) VALUES(?,?,?,?,?,?)";
    private static final String select_query = "SELECT Id FROM customer WHERE username = ? and password = ?";
    private Label lblNumber;

    public OrderDao() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Order> getOrders() {
        ObservableList<Order> orders = FXCollections.observableArrayList();

        try {

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM ORDERS";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int orderid = Integer.parseInt(rs.getString("ID"));

                int customerid = Integer.parseInt(rs.getString("CUSTOMERID"));

                String paymethod = rs.getString("PAYMETHOD");
                String getmethod = rs.getString("GETMETHOD");
                String request = rs.getString("REQUEST");
                Double total = rs.getDouble("TOTAL");
                

                Order order = new Order(orderid, customerid, paymethod, getmethod, request,total);
                orders.add(order);

            }

            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return orders;
    }


    public static void insertOrder(String customerid, String paymethod, String getmethod, String request, Double total) {

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");
                PreparedStatement preparedStatement = conn.prepareStatement(insert_query)) {

            preparedStatement.setString(1, customerid);
            preparedStatement.setString(2, paymethod);
            preparedStatement.setString(3, getmethod);
            preparedStatement.setString(4, request);
            preparedStatement.setDouble(5, total);

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
