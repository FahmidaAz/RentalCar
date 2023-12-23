
package Azmin.CAR;


import Azmin.DBSPT.DBSupport;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;

import java.util.concurrent.TimeUnit;


public class Booking{
   
    private int Bookingid;
    private String username;
    private String pricePerDay;  
    private Date startDate;
    private Date endDate;
    private String carID;
    private double totalPrice;

    public Booking(String username, String pricePerDay, Date startDate, Date endDate,String carID) {
        Random R = new Random();
        this.Bookingid = R.nextInt(1000)+1000;
        this.username = username;
        this.pricePerDay = pricePerDay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carID = carID;
        this.totalPrice = calculateTotalCost();
    }

    public int getBookingid() {
        return Bookingid;
    }

    public void setBookingid(int Bookingid) {
        this.Bookingid = Bookingid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

   
     
   public double calculateTotalCost() {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return Double.parseDouble(pricePerDay) * diffInDays;
    }

    @Override
    public String toString() {
        return "<div class='container'>" 
                + "<h4>Bookingid: " + this.Bookingid 
                + "</h4><br><h4> Username: " + this.username 
                + "</h4><br><h4>Price Per Day: " + this.pricePerDay 
                + "</h4><br><h4> Pick Up Date: " + this.startDate 
                + "</h4><br><h4> DropOff Date: " + this.endDate
                +"</h4><br><h4> CarID: " + this.carID
                + "</h4><br><h4> Total Cost: " + this.totalPrice+"</h4>"
                + "</div>";
    }
   public String toHTML(){
       return this.toString();
   }
   
   public void toSQL() throws SQLException, ClassNotFoundException{
       String q = "INSERT INTO bookings VALUES("+Bookingid+",'"+username+"','"
               +pricePerDay+"','"+startDate+"','"+endDate+"','"+carID+"',"+totalPrice+");";
       DBSupport.executeQuery(q);
   }
}