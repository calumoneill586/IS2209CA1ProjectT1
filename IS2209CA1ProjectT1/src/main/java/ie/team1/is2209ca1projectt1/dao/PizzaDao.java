package ie.team1.is2209ca1projectt1.dao;



//import ie.team1.is2209ca1projectt1.Pizza;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 120463034
 */
public class PizzaDao {
        private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public PizzaDao() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public List<Pizza> getPizzas() {

        List<Pizza>pizzas = new ArrayList<Pizza>();
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM PIZZA";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                double price = rs.getInt("PRICE");

                Pizza pizza = new Pizza(id, name, price);
                pizzas.add(pizza);
            }

            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong with select from pizza");
        }

        return pizzas;
    }
           
    public Pizza addPizza(Pizza pizzaToAdd) {
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO pizza (NAME, PRICE) VALUES('" + pizzaToAdd.getName() + "', " + pizzaToAdd.getPrice() + ")";
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            
        } catch(Exception ex) {
            System.out.println("something went wrong...");
            System.out.println(ex.getMessage());
        }
        
        return pizzaToAdd;
    }

    public List<Ingredient> getIngredientsForPizza(int pizzaId) {
        
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "select pizza.*, pizzaingredientlookup.*, ingredient.id as ingredientId, ingredient.name as ingredientName from pizza " +
            "inner join pizzaingredientlookup on pizza.id = pizzaingredientlookup.pizzaid inner join ingredient on pizzaingredientlookup.ingredientid = ingredient.id " +
            "where pizza.id = " + pizzaId;
 
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ingredientId");
                String name = rs.getString("ingredientName");

                Ingredient ingredient = new Ingredient(id, name);
                ingredients.add(ingredient);
            }

            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return ingredients;
        
    }
    

   

}
