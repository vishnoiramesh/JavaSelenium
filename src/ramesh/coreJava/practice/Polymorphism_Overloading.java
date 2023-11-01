package ramesh.coreJava.practice;

public class Polymorphism_Overloading {
	int a = 0;
	void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public  Polymorphism_Overloading(){
		int a =9;
		 this.a= 6;
		 System.out.println("Object Created with local variable: " + a + ": " + this.a);
	}
	
	public  Polymorphism_Overloading(int a){
		 this.a= a;
		 System.out.println("Object Created with local variable overlaod: " + this.a);
	}
	
//	int sum(int a, int b) {
//		System.out.println(a + b);
//		return 5;
//	}
	
	char sum(char x, int y) {
		System.out.println(x + y);
		return '5';
	}

	void sum(int a, float b) {
		System.out.println(a + b);
		
	}
	
	int sum(float b, int a) {
		System.out.println(a + b);
		return 5;
	}
	
	void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

//	void sum(int b, int a, int c) {   // Not polymorphic, Duplicate as all 3 parameters types are same with previous method.
//		System.out.println(a + b + c);
//	}
	public static void main(String args[]) {
		Polymorphism_Overloading obj = new Polymorphism_Overloading();
		obj.sum(10, 10, 10);
		obj.sum(20, 20);
		obj.sum(10, 100.0f);
		
		Polymorphism_Overloading obj1 = new Polymorphism_Overloading(100000);
		obj1.sum('R', 8);

	}
	
//	sum (int, int)
//	sum (char, int)
//	sum (int, float)
//	sum (float, int)
//	sum (int, int, int)
}
