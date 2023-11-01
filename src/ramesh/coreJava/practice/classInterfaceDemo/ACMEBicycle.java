package ramesh.coreJava.practice.classInterfaceDemo;


//abstract- all methods of interface are not fully implemented.
class ACMEBicycle implements BicycleInterface {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

   // The compiler will now require that methods
   // changeCadence, changeGear, speedUp, and applyBrakes
   // all be implemented. Compilation will fail if those
   // methods are missing from this class.

    public void changeCadence(int newValue) {
         cadence = newValue;
    }
    
   // abstract public void changeCadence(int newValue) 

    public void changeGear(int newValue) {
         gear = newValue;
    }

    public void speedUp(int increment) {
         speed = speed + increment;   
    }

    public void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
    
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
    	ACMEBicycle bike1 = new ACMEBicycle();
        ACMEBicycle bike2 = new ACMEBicycle();
        
        BicycleInterface bike3 = new ACMEBicycle();
        
       // bike3.printStates();
        bike3.changeGear(100);

        // Invoke methods on 
        // those objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();
}
}