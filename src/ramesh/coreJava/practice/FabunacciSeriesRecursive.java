package ramesh.coreJava.practice;

public class FabunacciSeriesRecursive {


	
	public static int n1=0, n2=1,n3=0;
	public static void main(String args[])
	{
		int count=10;
		System.out.print( n1 +" "+ n2 );
		printFabunacci(count-2);
		
		
	}
			public static void  printFabunacci(int count){
			if (count>0){
				n3=n1+n2;
				System.out.print(" "+n3);
				n1=n2;
				n2=n3;
				printFabunacci(count-1);
				
			}
		
	}
	

}
