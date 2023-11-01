package ramesh.coreJava.practice.classInterfaceDemo;

interface BicycleInterface  {  // can be, extends otherInterface
	
	final int MYCLASS =10;
	// int a

    //  wheel revolutions per minute
	abstract void  changeCadence(int newValue); // Abstract is optional.

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}