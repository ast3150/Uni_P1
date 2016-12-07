/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
    	long fibo = fib(50);
    	System.out.println(fibo);
   	}

    // 6-1.1 NOTE: On running with (i = 50) the execution takes a very long time, 
    // because this is not optimized properly and calculates the same values many times.
    public static long fib(int i) {
    	if (i == 0 || i == 1) {
    		return i;
    	} else {
    		return fib(i-1) + fib(i-2);
    	}
    }

}