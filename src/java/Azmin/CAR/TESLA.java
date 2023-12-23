
package Azmin.CAR;

import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;


public class TESLA extends Car{

//    public TESLA(CarType cartype) {
//        super(CarType.TESLA);
//    }
    
    public TESLA(String Carid, String model, String pricePerDay, Availability isAvailable) {
        super(Carid,CarType.TESLA, model, pricePerDay,isAvailable);
    }


    
    
    
}
