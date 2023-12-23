
package Azmin.CAR;

import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;


public class TOYOTA extends Car{

//    public TOYOTA(CarType cartype) {
//        super(CarType.TOYOTA);
//    }
     
    public TOYOTA(String Carid, String model, String pricePerDay, Availability isAvailable) {
        super(Carid,CarType.TOYOTA,model, pricePerDay,isAvailable);
    }


    
}
