/*
 * @Author:        Alain Stulz
 * @Matriculation: 16-119-414
 * @Author:        Pascal Wallimann
 * @Matriculation: 16-100-802
 * @Date created:  2016-10-19 15:50:06
 */

public class B {
	public static void main(String args[]){

		A a1 = new A(); // Create an instance a1 of A
		A a2 = new A(); // Create another instance a2 of A
		a1.increment(); // Set counter in a1 to 4
		System.out.println(a1+"/"+a2);
		// Prints 4/3 because a1 and a2 refer to different objects

		a2 = a1; // Makes a2 point to same place as a1, a2 and a1 now referencing same object
		a2.increment();  // Set counter (of a2, thus a1) to 5
		System.out.println(a1+"/"+a2); 
		// Prints 5/5 because a1 and a2 refer to the same object, thus both have been increased

		String s1 = "ROCK"; // Creates an instance s1 of string literal
		String s2 = s1; // Creates another string with same value but different location in memory
		s2 = s2.toLowerCase(); // Lowercases s2 (ROCK -> rock)
		System.out.println(s1+"/"+s2);
		// Prints "ROCK/rock" because only the second instance has been modified, first one stays the same

		int j=1; // Creates an instance j of int literal 1
		int i=j; // Creates an instance i with same value as j but different location in memory
		j++; // Increases j to 2
		System.out.println(j+"/"+i);
		// Prints 2/1 because j and i are again different objects and only one is modified
	} 
}
