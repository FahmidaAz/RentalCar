
package Azmin.CAR;

import Azmin.ENUMS.Availability;
import Azmin.ENUMS.CarType;


public class FORD extends Car{

//    public FORD(CarType cartype) {
//        super(CarType.FORD);
//    }
   
    public FORD(String Carid, String model, String pricePerDay, Availability isAvailable) {
        
        super(Carid,CarType.FORD, model,pricePerDay , isAvailable);
        
    }

    
   
    
   
    
}
