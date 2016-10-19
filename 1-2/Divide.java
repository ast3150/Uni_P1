/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Date created:  2016-09-28 15:54:40
*/

import java.util.Scanner;

class Divide {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read dividend
		System.out.print("Enter dividend: ");
		float dividend = scanner.nextInt();

		// Read divisor
		System.out.print("Enter divisor: ");
		float divisor = scanner.nextInt();

		// Guard against div by 0
		if (divisor == 0) {
			System.out.println("Very funny. What did you expect to happen?");
			throw new IllegalArgumentException("Argument 'divisor' is 0");
		}

		// Calculate result
		float resultFloat = (dividend*dividend)/divisor;
		int resultInt = (int)resultFloat;
		int remainder = (int)(dividend*dividend)%(int)divisor;

		// Output
		System.out.println("--- Result: (" + dividend + "^2)/" + divisor + " ---");
		System.out.println("Float: " + resultFloat);
		System.out.println("Int:   " + resultInt + "   Remainder: " + remainder);

	}
}
