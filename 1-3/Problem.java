/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
* @Date created:  2016-09-28 16:02:50
*/

public class Problem {
	public static int a = 17; // remove 'final' keyword

	// remove semicolon following method declaration
	public static void main(String[] args) {
		int b = 24; // change boolean operator == to assign = operator
		double c = 3.41; 
		System.out.println("a = " + a); 
		

		a = a + b; // remove 'final' keyword in declaration of a
		System.out.println("a = " + a); 
		b = (int)c/2; // Explicitly cast double to int
		System.out.println("b = " + b);
	}
}
