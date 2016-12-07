/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.math.*;

public class Factorial {
    public static void main(String[] args) {
      long fact = factorial(Integer.parseInt(args[0]));
      System.out.println(fact);
    }

    // 6-1.2 NOTE: This takes less time to run because there are fewer
    // redundant calls to the function. For example fib(50) will calculate fib(10) many times,
    // but fact(10) calculates each lesser factorial only once.
    public static long factorial(int n) {
    	if (n == 0) {
    		return 1;
    	} else {
    		return n * factorial(n-1);
    	}
    }
}
