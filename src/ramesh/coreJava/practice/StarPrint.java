package ramesh.coreJava.practice;

import java.util.Scanner;

public class StarPrint {
	public static void main(String[] args) {
		int rowNo;
		Scanner SCN = new Scanner(System.in);
	
	    
	    System.out.println("Enter Number of Rows:"); 
	    
	    //rowNo = String.valueof(SCN.nextLine()); // Works when input is already a num but in String.
	    
	    rowNo = Integer.parseInt(SCN.nextLine());
	    
	    for (int i = 1; i <= rowNo; i++) {
			for(int k = rowNo*2; k >= i;k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" * ");
			}
			System.out.print("\n");
		}

		for (int i = rowNo-1; i >= 0; i--) {
			for(int k = rowNo*2; k >= i;k--) {
				System.out.print(" ");
			}
			for (int j =1; j <= i; j++) {
				System.out.print(" * ");
			}
			System.out.print("\n");
		} 
	}
}
