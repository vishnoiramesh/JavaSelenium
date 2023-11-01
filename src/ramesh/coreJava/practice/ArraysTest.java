package ramesh.coreJava.practice;

import java.util.Arrays;

public class ArraysTest {
	static final String CONSTANT1 = "Java";
	final String CONSTANT2 = "Programming";

	public static void main(String args[]) {

		try {
			/* Example of primitive array */
			int[] intArray = { 99, 34, 120, 67, 2000 };
			float floatArray[] = new float[10];
			char charMultiDimArray[][] = { { 'R', 'A', 'M', 'E', 'S', 'H' },
					{ 'K', 'U', 'M', 'A', 'R' },
					{ 'V', 'I', 'S', 'H', 'N', 'O', 'I' } };

			int lengthOfintArray = intArray.length;
			System.out.println("Length of in Int Array: " + lengthOfintArray);
			System.out.println("Length of Float Array: " + floatArray.length);
			System.out.println("Length of Multi Dim Char Array: "
					+ charMultiDimArray.length);

			for (int i = 0; i < charMultiDimArray.length; i++) {
				for (int j = 0; j < charMultiDimArray[i].length; j++) {
					System.out.println("Char Multi Dim Array[" + i + "][" + j
							+ "]: " + charMultiDimArray[i][j]);

				}
			}

			/*
			 * Using Static Arrays class on already declared array to perform
			 * some operations on them
			 */
			Arrays.sort(intArray);
			System.out.println("Sorted Array: " + Arrays.toString(intArray));

			int found = Arrays.binarySearch(intArray, 120); // It will search
															// only in sorted
															// array.
			System.out.println("Found 120?: " + found);
			found = Arrays.binarySearch(intArray, 348); // It will search only
														// in sorted array.
			System.out.println("Found 348, Befrore fill?: " + found);

			Arrays.fill(intArray, 348); // All the elements will be replaced by
										// 348. 
			System.out.println("Fill: " + Arrays.toString(intArray));
			found = Arrays.binarySearch(intArray, 348); // It will search only
														// in sorted array. It
														// will give first
														// result from middle, if elements
														// found many times.
			System.out.println("Found 348, After fill?: " + found);

			/*
			 * Similar to primitive array arrays of objects can be
			 * used.
			 */

			ArraysTest[] myObjectArray = new ArraysTest[10]; // Array
																// declaration.
			myObjectArray[1] = new ArraysTest();

			System.out.println("\nValue of Constant1: "
					+ ArraysTest.CONSTANT1);
			System.out.println("Value of Constant2: "
					+ myObjectArray[1].CONSTANT2);
		} catch (ArrayIndexOutOfBoundsException arrayIndexOBE) {
			arrayIndexOBE.printStackTrace();
		}

	}
}