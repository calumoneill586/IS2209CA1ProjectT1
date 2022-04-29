
package ie.team1.is2209ca1projectt1.dao;

/**
 *
 * @author Orla
**/




public class Customer {
 private String name, addressline1, addressline2, creditcardno, phoneno, allergies, username,password;
   private int id;
    public Customer(int id, String name, String addressline1, String addressline2, String creditcardno, String phoneno, String allergies, String username, String Password ) {
       this.id = id;
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.creditcardno = creditcardno;
        this.phoneno = phoneno;
        this.allergies = allergies;
        this.username = username;
        this.password = password;
        
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String creditcardno) {
        this.creditcardno = creditcardno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
       return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressline1;
    }
     
    public void setAddressLine1 (String addressline1) {
        this.addressline1 = addressline1;
    }

   public String getAddressLine2() {
       return addressline2;
    }
    public void setAddressLine2 (String addressline2) {
        this.addressline2 = addressline2;
    }
   
   public String getCreditCardNo() {
       return creditcardno;
    }

    public void setCreditCardNo (String creditcardno) {
        this.creditcardno = creditcardno;
    }
    
   public  String getPhoneNo() {
       return phoneno;
    }
    
    public void setPhoneNo (String phoneno) {
        this.phoneno = phoneno;
    }

   public String getAllergies() {
      return allergies;
    }

    public void setAllergies (String allergies) {
        this.allergies = allergies;
    }
    
   public  String getUsername() {
      return username;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
 
    public String getPassword() {
      return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }

    @Override

    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", addressline1=" + addressline1 +", addressline2=" + addressline2 +", creditcardno=" + creditcardno+", phoneno=" + phoneno + ", allergies=" + allergies+ ", username=" + username+ ", password=" + password+   '}';
    
    }
 
}
   



