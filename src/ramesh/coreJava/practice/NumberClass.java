package ramesh.coreJava.practice;

public class NumberClass {
	public static void main(String[] args) {
		Integer intObj = new Integer("10");

		// use intValue method of Integer class to convert it into int type.
		int i = intObj.intValue();
		System.out.println("Int: " + i);

		// use doubleValue method of Integer class to convert it into double
		// type.
		double d = intObj.doubleValue();
		System.out.println("Double: " +d);

		// use shortValue method of Integer class to convert it into short type.
		short s = intObj.shortValue();
		System.out.println("Short: " +s);

		String myIntNumber = "55";
		String myFloatNumber = "55.90";


		Integer myInt1 = Integer.valueOf(100);
		
		Integer myInt2 = Integer.parseInt(myIntNumber);
		
		int additionOfInt = myInt1 + myInt2;
		System.out.println("Int Addition: " + additionOfInt);

		Float myFloat1 = Float.valueOf(111.00f);		
		Float myFloat2 = Float.parseFloat(myFloatNumber);
		
		float additionOfFloat = myFloat1 + myFloat2;
		System.out.println("Foat Addition: " + additionOfFloat);
	}
}