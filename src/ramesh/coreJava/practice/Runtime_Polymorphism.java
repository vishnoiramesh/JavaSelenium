package ramesh.coreJava.practice;

class Bike {
	void run() {
		System.out.println("Running With Super Class.");
	}

	void stop() {
		System.out.println("Stopped in Super Class");
	}
}

class Sibling extends Bike {
	public void siblingMethod() {
		System.out.println("Running With Sibling Class.");
	}
}

public class Runtime_Polymorphism extends Bike {
	void run() {
		System.out.println("Running safely with Subclass");
	}

	void fun() {
		System.out.println("Fun in SubClass");
	}

	public static void main(String args[]) {
		System.out.println("1. =======================================");
		Bike b1 = new Runtime_Polymorphism();// Up casting
		b1.run();
		b1.stop();
		// b1.fun();

		System.out.println("2. =======================================");
		Bike b2 = new Bike();// No casting
		b2.run();
		b2.stop();
		// b2.fun();

		System.out.println(" 3. =======================================");
		Runtime_Polymorphism b3 = new Runtime_Polymorphism();// No casting
		b3.run();
		b3.stop();
		b3.fun();

		System.out.println("4. =======================================");
		Bike b4 = new Sibling();
		b4.run();
		b4.stop();
		// b4.fun();
		System.out.println("==============================================");

	}
}
