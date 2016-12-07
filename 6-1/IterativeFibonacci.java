/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.math.*;

public class IterativeFibonacci {

    public static void main(String[] args) {
    	BigInteger result = fib(BigInteger.valueOf(50));
    	System.out.println(result);
    }

    public static BigInteger fib(BigInteger n) {
    	if (n.equals(BigInteger.ZERO)) return BigInteger.ZERO;
    	if (n.compareTo(BigInteger.ZERO) == 1 && n.compareTo(BigInteger.valueOf(3)) == -1) return BigInteger.valueOf(1);

    	BigInteger result = BigInteger.valueOf(0);
    	BigInteger lastResult = BigInteger.valueOf(1);
    	BigInteger beforeLastResult = BigInteger.valueOf(1);

    	for (int i=2; n.compareTo(BigInteger.valueOf(i)) > 0; i++) {
    		result = lastResult.add(beforeLastResult);
    		beforeLastResult = lastResult;
    		lastResult = result;
    	}

    	return result;
    }
}