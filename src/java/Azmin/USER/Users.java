
package Azmin.USER;

import Azmin.DBSPT.DBSupport;
import java.sql.SQLException;
import java.util.Random;


public class Users {
    private int Usrid;
    private String username;
    private String email;
    private String phone;
    private String address;
  public Users(){
      
  }
    public Users(String username, String email, String phone, String address) {
        Random R = new Random();
        this.Usrid = R.nextInt(1000)+1000;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getUsrid() {
        return Usrid;
    }

    public void setUsrid(int Usrid) {
        this.Usrid = Usrid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
    return "<div class='container'><br>"
           + "<p>UserID: " + Usrid + "</p> <p>UserName: " + this.username + "</p><br>"
           + "<p>Email: " + this.email + "</p><br><p>Phone: " + this.phone + "</p><br>"
           + "<p>Address: " + this.address + "</p>";
   }
   public String toHTML(){
       return this.toString();
   }
   public void toSQL() throws SQLException, ClassNotFoundException{
        String q = "INSERT INTO users VALUES("+this.Usrid+",'"+this.username
                +"','"+this.email+"','"+this.phone+"','"+this.address+"');";
        DBSupport.executeQuery(q);
              
    }
  
}
