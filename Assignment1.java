import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment1 {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		// System.out.println("answer is: " + addNumber());

		System.out.println("for that index, the value is: " + showIndex());

	}

	// question 1
	private static int addNumber() {

		int num1 = 0;
		int num2 = 0;

		boolean flag1 = true;

		while (flag1) {
			try {
				System.out.println("input the first number: ");
				num1 = s.nextInt();
				flag1 = false;
			} catch (InputMismatchException e) {
				System.out.println("invalid input, try again\n");
				s.nextLine();
			}
		}

		boolean flag2 = true;

		while (flag2) {
			try {
				System.out.println("input the second number: ");
				num2 = s.nextInt();
				flag2 = false;
			} catch (InputMismatchException e) {
				System.out.println("invalid input, try again\n");
				s.nextLine();
			}
		}

		return num1 + num2;
	}

	// question 2
	private static int showIndex() {

		int[] randArr = new int[100];

		for (int i = 0; i < 100; i++) {
			randArr[i] = (int) (Math.random() * 1000);
		}

		int arrIndex = 0;

		boolean flag1 = true;

		while (flag1) {
			try {
				System.out.println("what index would you like to see (0-99) : ");
				arrIndex = randArr[s.nextInt()];
				flag1 = false;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Out of Bounds, try again\n");
				s.nextLine();
			}
		}

		return arrIndex;
	}

}
