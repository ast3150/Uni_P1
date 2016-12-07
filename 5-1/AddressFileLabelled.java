/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class AddressFileLabelled extends AddressFile {

	public AddressFileLabelled(String filename) {
		super(filename);
	}

    /// Converts Address to labeled, comma separated String
	private String toLine(Address addr) {
		String addressStr = "";
		addressStr += "id:" + addr.getId() + ", ";
		addressStr += "name:" + addr.getName() + ", ";
		addressStr += "street:" + addr.getStreet() + ", ";
		addressStr += "zip:" + addr.getZipCode() + ", ";
		addressStr += "city:" + addr.getCity();

		return addressStr;
	}

	/// Tries to read an Address from a labeled, comma separated String
	private Address parseLine(String line) throws AddressFileException {
		Scanner scn = new Scanner(line);
		String regEx = "[\\s]*:[\\s]*([^;]*)";

		try {
			scn.findInLine("id" + regEx);
			Integer id = new Integer( scn.match().group(1).trim() );
			
			scn.findInLine("name" + regEx);
			String name = scn.match().group(1).trim();
			
			scn.findInLine("street" + regEx);
			String street = scn.match().group(1).trim();

			scn.findInLine("zip" + regEx);
			Integer zip = new Integer( scn.match().group(1).trim() );

			scn.findInLine("city" + regEx);
			String city = scn.match().group(1).trim();

			return new Address(id, name, street, zip, city);
		} catch (Exception e) {
			throw new AddressFileException("ERROR: Invalid input. " + e.getMessage());
		}
	}
}