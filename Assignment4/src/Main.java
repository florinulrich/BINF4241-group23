public class Main {

    public static void main(String[] args){

        Smartphone sp = new Smartphone();
        Submenu testSubmenue = new Submenu("est");

        sp.addSubmenu(testSubmenue);
        sp.display();

    }
}
