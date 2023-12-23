
package Azmin.CAR;

import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;


public class KIA extends Car{

//    public KIA(CarType cartype) {
//        super(CarType.KIA);
//    }
    
    public KIA(String Carid, String model, String pricePerDay, Availability isAvailable) {
        super(Carid,CarType.KIA, model, pricePerDay,isAvailable);
    }


    
}
