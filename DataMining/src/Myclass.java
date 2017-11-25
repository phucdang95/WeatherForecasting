
import java.util.Random;

public class Myclass {
	static int[][] matrixA = new int[7][4]; // Declaring matrix A of size 7x4
	static int[][] matrixB = new int[14][4]; // Declaring matrix B of size 14x4

	public static void createMatrixB() // Creating Matrix B with random numbers
	{
		Random rand = new Random();

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				Integer r = rand.nextInt() % 100; // Random numbers created will
													// be less than 100
				matrixB[i][j] = Math.abs(r); // It will extract the absoute
												// values/positive values of the
												// number
			}
		}

	}

	public static void printMatrixB() // This function will print matrix B
	{
		System.out.println("Matrix B");
		System.out.println("-------------");
		for (int i = 0; i < 14; i++) {

			for (int j = 0; j < 4; j++) {
				System.out.print(matrixB[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void printMatrixA() // This function will print matrix A
	{
		// System.out.println("test3 ");
		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 4; j++) {
				System.out.print(matrixA[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void createSlidingWindow() // This function will create the
												// sliding windows and store in
												// matrix A one by one.
	{
		for (int window = 0; window < 8; window++) // This for loop will
													// determine the count of
													// windows
		{
			System.out.println();
			System.out.println("Window : " + (window + 1));
			System.out.println("-------------");
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 4; j++) {
					matrixA[i][j] = matrixB[i + window][j];
				}
			}
			printMatrixA();
		}
	}

	public static void main(String args[]) {
		createMatrixB();
		printMatrixB();
		createSlidingWindow();
	}
}