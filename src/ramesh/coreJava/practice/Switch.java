package ramesh.coreJava.practice;

public class Switch {
	enum Enum1 {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	};

	public static void main(String args[]) {
		// int iDay = 0;
		// if (iDay == 1) {
		// System.out.println("Monday");
		// }
		// else if (iDay == 2) {
		// System.out.println("Tuesday");
		// }
		// else if(iDay == 3){
		// System.out.println("Wednesday");
		// }
		//// ........
		//
		// else{
		// System.out.println("No match- Other");
		// }
		//
		int iDay = 1;

		for (iDay = 1; iDay < 5; iDay++) {
			System.out.println("Test");
			continue;
		}

		switch (iDay) {
		case 1:
			System.out.println("Today is Monday");
//			continue; Not allowed outside or without loops. Only in loops allowed.
		case 3:
			System.out.println("Today is Tuesday");
			break;
		case 4:
			System.out.println("Today is Wednesday");
			break;
		case 5:
			System.out.println("Today is Thursday");
			break;
		case 6:
			System.out.println("Today is Friday");
			break;
		case 7:
			System.out.println("Today is Saturday");
			break;
		default:
			System.out.println("Today is Sunday");
			break;
		}

		switch (Enum1.Monday) {
		case Monday:
			System.out.println("Today is Monday");
			break;
		case Tuesday:
			System.out.println("Today is Tuesday");
			break;
		case Wednesday:
			System.out.println("Today is Wednesday");
			break;
		case Thursday:
			System.out.println("Today is Thursday");
			break;
		case Friday:
			System.out.println("Today is Friday");
			break;
		case Saturday:
			System.out.println("Today is Saturday");
			break;
		default:
			System.out.println("Today is Sunday");
			break;
		}
 

	}

}
