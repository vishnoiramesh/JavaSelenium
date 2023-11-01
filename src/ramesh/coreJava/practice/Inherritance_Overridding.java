package ramesh.coreJava.practice;

class Bank {
	int baseRate = 4;
	int minimumBalanceRequired;

	void notOverriddenMethod() {
		int minimumBalanceRequired = 1000;
		this.minimumBalanceRequired = minimumBalanceRequired;
	}

	public void printBaseValue() {
		notOverriddenMethod();
		System.out.println("Minimum Balance Required: "
				+ minimumBalanceRequired);
	}

	int getRateOfInterest() {
		return baseRate;
	}
}

class SBI extends Bank {
	int getRateOfInterest() {
		return baseRate + 4;
	}
}

class ICICI extends Bank {
	int getRateOfInterest() {
		return baseRate + 3;
	}
}

class AXIS extends Bank {
	int getRateOfInterest() {
		return baseRate + 5;
	}
}

class Yes extends Bank {
	
 void mySubClassMethod(){
	 System.out.println("This is sub class method along with super class inheritetted method");
 }
}
public class Inherritance_Overridding {
	public static void main(String args[]) {
		SBI s = new SBI();
		ICICI i = new ICICI();
		AXIS a = new AXIS();
		Yes y = new Yes();
		s.printBaseValue();
		
		System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
		System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
		System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());
		System.out.println("Yes Bank Rate of Interest: " + y.getRateOfInterest());
		y.mySubClassMethod();
	}
}
