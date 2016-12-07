/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.*;
import java.util.*;
import java.lang.*;

public class MergeSort {

    public static void sort(Comparable[] array) {
		Comparable[] result = mergeSort(array);
		
		// This class does not implement in-place sorting so this just copies the result into the parameter array.
		// Probably not terribly efficient but it works fine for this purpose.
		for (int i = 0; i < result.length && i < array.length; i++) {
			array[i] = result[i];
		}
    }

    public static Comparable[] mergeSort(Comparable[] array) {
    	// Check for completion of recursion
    	if (array.length <= 1) {
    		return array;
    	}

  	 	int newSize = (array.length)/2;
    	Comparable[] lhs = new Comparable[newSize];
    	Comparable[] rhs = new Comparable[newSize];

    	if ((array.length % 2) > 0) {
    		// Array length is not even, make rhs 1 item larger
    		rhs = new Comparable[newSize + 1];
    	}

		// Split arrays in half
    	for (int i = 0; i < array.length; i++) {
    		if (i < newSize) {
    			lhs[i] = array[i];
    		} else {
    			rhs[i - newSize] = array[i];
    		}
    	}

    	// Sort the split arrays recursively
    	lhs = mergeSort(lhs);
    	rhs = mergeSort(rhs);

    	array = merge(lhs, rhs);
    	return array;
    }

    public static Comparable[] merge(Comparable[] lhs, Comparable[] rhs) {
    	Comparable[] result = new Comparable[(lhs.length + rhs.length)];

    	// Used to determine the next index to compare, and the index to insert into the result
    	int nextLhs = 0;
    	int nextRhs = 0;

    	// Compare and merge the objects in both arrays
    	while (nextLhs < lhs.length && nextRhs < rhs.length) {
    		int comparison = lhs[nextLhs].compareTo(rhs[nextRhs]);
    		int nextResult = nextLhs + nextRhs;

    		if ( comparison < 0 ) {
    			// lhs is smaller
    			result[nextResult] = lhs[nextLhs];
    			nextLhs++;
    		} else {
    			// rhs is smaller
    			result[nextResult] = rhs[nextRhs];
    			nextRhs++;
    		}
    	}

    	// Append remaining objects from either array.
    	// Only one statement will be executed.
    	while (nextLhs < lhs.length) {
    		result[nextLhs + nextRhs] = lhs[nextLhs];
    		nextLhs++;
    	}

    	while(nextRhs < rhs.length) {
    		result[nextLhs + nextRhs] = rhs[nextRhs];
    		nextRhs++;
    	}

    	return result;
    }
}