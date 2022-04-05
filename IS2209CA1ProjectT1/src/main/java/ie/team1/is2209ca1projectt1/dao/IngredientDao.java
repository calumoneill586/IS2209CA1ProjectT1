package ie.team1.is2209ca1projectt1.dao;



//import ie.team1.is2209ca1projectt1.Pizza;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class IngredientDao {
        private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public IngredientDao() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public List<Ingredient> getIngredients() {

        List<Ingredient>ingredients = new ArrayList<Ingredient>();
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM INGREDIENT";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
            
                
                

                Ingredient ingredient = new Ingredient(id, name);
                ingredients.add(ingredient);
            }

            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong with select from ingredient");
        }

        return ingredients;
    }
        
    
    

}