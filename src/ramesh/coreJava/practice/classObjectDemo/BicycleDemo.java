package ramesh.coreJava.practice.classObjectDemo;

class BicycleDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Bicycle bike1 = new Bicycle();
        Bicycle bike2 = new Bicycle();

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
        
        
//        public void over (char a, int b){}
//        public void over (int b, char a){}  // Yes
//        public void over (int b, int a){} //No
//        public void over (int a, int b){}//
//        public int over (int a, int b){}   // No
//        public void over (int a, int b, int c){} //Yes
//        public void over (char a, int b){}  // Yes
//        public void overLoading (int a, int b){}
//        private void over (int a, int b){}
    }
}