import Devices.Dishwasher;
import Devices.Microwave;
import Devices.Oven;

public class Main {

    public static void main(String[] args){

        Smartphone mySmartphone = new Smartphone();

        //Add Devices
        Oven myOven = new Oven();
        mySmartphone.addCommand(new Submenu("Oven", myOven));

        Microwave myMicrowave = new Microwave();
        mySmartphone.addCommand(new Submenu("Microwave", myMicrowave));

        Dishwasher myDishwasher = new Dishwasher();
        mySmartphone.addCommand(new Submenu("Dishwasher", myDishwasher));

        //Add more...

        //Run
        mySmartphone.display();
    }
}
