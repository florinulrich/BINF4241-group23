public class Main {

    public static void main(String[] args){

        Smartphone mySmartphone = new Smartphone();

        //Add Oven
        mySmartphone.addCommand(new Submenu("Oven"));


        //Add more...

        //Run
        mySmartphone.display();
    }
}
