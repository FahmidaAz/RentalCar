
package Azmin.CAR;

import Azmin.DBSPT.DBSupport;
import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;
import java.sql.SQLException;
import Azmin.INTERFACES.Information;

public abstract class Car implements Information{
    
    private String Carid;
    private CarType cartype;
    private String model;
    private String pricePerDay;
    private Availability isAvailable;

    public Car(CarType cartype) {
        this.cartype = cartype;
    }
    
    

    public Car(String Carid,CarType cartype, String model, String pricePerDay, Availability isAvailable) {
        this.Carid = Carid;
        this.cartype = cartype;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    public String getCarid() {
        return Carid;
    }

    public void setCarid(String Carid) {
        this.Carid = Carid;
    }

    public CarType getCartype() {
        return cartype;
    }

    public void setCartype(CarType cartype) {
        this.cartype = cartype;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Availability getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Availability isAvailable) {
        this.isAvailable = isAvailable;
    }


    @Override
    public String toString() {
        return  
                 "<tr><td>" + Carid 
                + "</td><td>" + cartype 
                + "</td><td> " + model 
                + "</td><td> " + pricePerDay
                + "</td><td> " + isAvailable+"</td></tr>";
    }

    public String toHTML(){
        return this.toString();
    }
   public void toSQL() throws SQLException, ClassNotFoundException{
        String q = "INSERT INTO cars VALUES('"+Carid+"','"+cartype
                +"','"+model+"','"+pricePerDay+"','"+isAvailable+"');";
        DBSupport.executeQuery(q);
    }
}