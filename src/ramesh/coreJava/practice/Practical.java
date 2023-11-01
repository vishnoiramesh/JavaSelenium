package ramesh.coreJava.practice;

public class Practical {
   // INtance variables declaration.
	int a = 5;
	float b = 0.0f;
	// Class (Static/ Global) variable.
	public static double common = 100.00;
	// This method simply prints the values of initial values of variables.
	public void print(){
	System.out.println("Value of a: " + a + " Value of b: " + b);
	}
	// By calling this method in future will set/ reset the values of your variables.
	public void setValues(int x, int y) {
		a =y;
		b = x;
	}
	// By calling this method in future will show you the values of your variables.
	public int getValues(byte choiceOfVariableToRead) {
		
		if (choiceOfVariableToRead == 1){
		return a;}
		else
		{
			return (int)b;
		}

	}

	public static void main(String args[]) {
//		Practical p1 = new Practical();
//		Practical p2 = new Practical();
//		p1.print();
//		p1.setValues(90.0f, 50);
//		p1.print();
//		p2.print();
//		p2.setValues(3.0f, 2);
//		System.out.println("Value of a varible is (By method): "
//				+ p1.getValues((byte)1));
//		System.out.println("Value of a varible is (By variable): " + p1.a);
//		System.out.println(" Value of b: " + p1.b);
//		System.out.println(" Value of common: " + common);
//		System.out.println("Value of a varible is (By method): "
//				+ p2.getValues((byte)2));
//		System.out.println("Value of a varible is (By variable): " + p2.a);
//		System.out.println(" Value of b: " + p2.b);
		Practical[]  P = new Practical [5];
	for (int i = 0; i<5; i++){		
		P[i]= new Practical ();
		P[i].print();
		P[i].setValues(90, i);
		P[i].print();
		
	}
		
	}
}
