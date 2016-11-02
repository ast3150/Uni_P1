/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Date created:  2016-10-07 12:38:15
*/

/* ************************************************************************* *\
*                Programmierung 1 HS 2016 - Serie 2-1                         * 
\* ************************************************************************* */

import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN {

	public static void main( String args[] ) {
		System.out.println("1st ISBN: " + makeISBN());
		System.out.println("2nd ISBN: " + makeISBN());
		System.out.println("3rd ISBN: " + makeISBN());
	}

	/** generates and returns a random ISBN in the format XX-XXX-XX-C */
	public static String makeISBN() {
		// Do NOT change the declaration of the following variables!
		String laendercode;
		String bandnr;
		String verlagsnr;
		String checksum;
		int checksumInt;

		Random randomizer = new java.util.Random();
		DecimalFormat normalF = new DecimalFormat("#00");
		DecimalFormat checksumF = new DecimalFormat("0");

		laendercode = normalF.format(randomizer.nextInt(99));
		bandnr = normalF.format(randomizer.nextInt(899)+100);
		verlagsnr = normalF.format(randomizer.nextInt(99));

		checksumInt = hashOp(Character.getNumericValue(laendercode.charAt(0))) + Character.getNumericValue(laendercode.charAt(1));
		checksumInt += hashOp(Character.getNumericValue(bandnr.charAt(0))) + Character.getNumericValue(bandnr.charAt(1)) + hashOp(Character.getNumericValue((int)bandnr.charAt(2)));
		checksumInt += Character.getNumericValue(verlagsnr.charAt(0)) + hashOp(Character.getNumericValue(verlagsnr.charAt(1)));
		checksumInt %= 10;
		checksum = checksumF.format(checksumInt);
		
		// Do not change the following line
		return laendercode + "-" + bandnr + "-" + verlagsnr + "-" + checksum;
	}

	/** multiplies i with 2 and subtracts 9 if result is >= 10 */
	public static int hashOp( int i ) {
		// Do NOT change this method!
		int doubled = 2 * i;
		if ( doubled >= 10 ) {
			doubled = doubled - 9;
		}
		return doubled;
	}
}
