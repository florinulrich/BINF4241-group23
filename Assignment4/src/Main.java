import Devices.*;
import Utilities.Smartphone;
import Utilities.Submenu;

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

        Washer myWasher = new Washer();
        mySmartphone.addCommand(new Submenu("Washer", myWasher));

        CleaningRobot myCleaningRobot = new CleaningRobot();
        mySmartphone.addCommand(new Submenu("Cleaning Robot", myCleaningRobot));

        //Add more...

        //Run
        while (!mySmartphone.quitProgram()) {
            mySmartphone.display();
        }
    }
}
