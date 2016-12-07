/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

public class IterativeToRecursive {

	// 6-1.3 NOTE: Any loop can be implemented by giving the right conditions as variables. 
	// E.g. a for loop can be implemented by using a counter and a maximum value, comparing the counter to the maximum in the  method body.
	// Other loops could simply be made using a condition that can change its value during recursive calls.

    public static void main(String[] args) {
    	System.out.println("ITERATIVE");
		for(int i=0; i<=30; i+=3) System.out.println(i);

		System.out.println("RECURSIVE");
		recursive(0, 30);
    }
	
	static void recursive(int i, int max) {
		if (i <= max) {
			System.out.println(i);
			recursive(i + 3, max);
		} else {
			return;
		}
	}

}