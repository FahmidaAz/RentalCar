 
package Azmin.FACTORY;

import Azmin.CAR.Car;
import Azmin.DBSPT.DBSupport;
import java.util.ArrayList;
import java.util.Random;
import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;
import static Azmin.ENUMS.CarType.FORD;
import static Azmin.ENUMS.CarType.KIA;
import static Azmin.ENUMS.CarType.TESLA;
import static Azmin.ENUMS.CarType.TOYOTA;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import Azmin.INTERFACES.Information;


public class CarBuilder {
    public static ArrayList<Car> BuildCar(){
      ArrayList<Car> cars = new ArrayList<>();
       Random r = new Random();
        CarType[] carTypes = CarType.values();
        for (int i = 0; i < 50; i++) {
            
            String carId = "CityHop-"+(i + 1);
            final CarType carType = carTypes[r.nextInt(carTypes.length)];
           Availability availability = r.nextBoolean() ? Availability.AVAILABLE : Availability.NOTAVAILABLE;
           Car car;
        switch (carType) {
            case TOYOTA:
                car = new Car(carId, carType, "Camry", "45", availability) {};
                break;
            case FORD:
                car = new Car(carId, carType, "SUV", "50", availability) {};
                break;
            case TESLA:
                car = new Car(carId, carType, "Model X", "60", availability) {};
                break;
            case KIA:
                car = new Car(carId, carType, "Soul", "40", availability) {};
                break;
            default:
                car = new Car(carId, carType, "DefaultModel", "DefaultPrice", availability) {};
                break;
        }

        cars.add(car);
    }
    return cars;
}
     public static String getCar(String carIDStr,String cartypeStr) throws SQLException, ClassNotFoundException{
       
    
      String query = "SELECT pricePerDay FROM cars WHERE carID = '" + carIDStr + "' AND carType = '" + cartypeStr + "'";
    try {
        String pricePerDay = DBSupport.executeResultsQuery(query);
        return pricePerDay;
    } catch (SQLException | ClassNotFoundException e) {
     //  e.printStackTrace();
        return null; 
    }
    }
    
     

   public static void fileCarAccount(ArrayList<Car> cars) throws IOException {
      
        String filePath = Information.cars;
       try (FileWriter FW = new FileWriter(filePath);
             BufferedWriter BW = new BufferedWriter(FW)) {

            for (Car car : cars) {
                String formattedString = String.format(
                        "CarId: %s, CarType: %s, Model: %s, PricePerDay: %s, Availability: %s%n",
                        car.getCarid(), car.getCartype(), car.getModel(),
                        car.getPricePerDay(), car.getIsAvailable());

                BW.write(formattedString);
            }
               BW.close();
        }
    
        
    }
}
      
       
            
        

