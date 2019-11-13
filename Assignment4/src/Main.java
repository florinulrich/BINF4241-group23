import Devices.Oven;

public class Main {

    public static void main(String[] args){

        Smartphone mySmartphone = new Smartphone();

        //Add Oven
        Oven myOven = new Oven();
        mySmartphone.addCommand(new Submenu("Oven", myOven));


        //Add more...

        //Run
        mySmartphone.display();
    }
}
