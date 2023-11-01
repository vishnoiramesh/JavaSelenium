package ramesh.coreJava.practice;

public class ExceptionHandling {
	// it throws means ignores
	static void exceptionIgnored() throws NullPointerException { // If you don't
																	// know
																	// exact
																	// name then
																	// write
																	// Exception.
		// System.out.println(5/0); // Throws means pass to caller. Ignore here.
	}

	static void CustomException() {
		// Please throw new exception.
		throw new ArithmeticException("Not valid");
		// To write your own error message on log or console to make user
		// friendly.
	}

	public static void main(String args[]) {
		try {
			int data = 25;
			System.out.println(data + "\n");

			int[] arr = { 1, 20, 300, 4000 };
			System.out.println(arr[100]);

			exceptionIgnored();

			CustomException();

		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		} catch (ArrayIndexOutOfBoundsException aib) {
			aib.printStackTrace();
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		} catch (Throwable te) {
			System.out.println(te.getMessage());
		} finally {
			System.out.println("finally block is always executed");
		}
		System.out.println("rest of the code...");
	}
}
