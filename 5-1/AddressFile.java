/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.lang.*;
import java.util.*;
import java.io.*;

public class AddressFile {
	private String filename;

	public AddressFile(String filename) {
		this.filename = filename;
	}

    /// Converts Address to comma separated String
	private String toLine(Address addr) {
		String addressStr = "";
		addressStr += addr.getId() + ", ";
		addressStr += addr.getName() + ", ";
		addressStr += addr.getStreet() + ", ";
		addressStr += addr.getZipCode() + ", ";
		addressStr += addr.getCity();

		return addressStr;
	}

	/// Tries to read an Address from a comma separated String
	private Address parseLine(String line) throws AddressFileException {
		Scanner scn = new Scanner(line);
		scn.useDelimiter(",");

		try {
			Integer id = new Integer(scn.next().trim());
			String name = scn.next().trim();
			String street = scn.next().trim();
			Integer zip = new Integer(scn.next().trim());
			String city = scn.next().trim();
			return new Address(id, name, street, zip, city);

		} catch (Exception e) {
			throw new AddressFileException("ERROR: Invalid input. " + e.getMessage());
		}
	}

	public void save(ArrayList<Address> addresses) {
		try {
			File file = new File("./" + this.filename);
			file.getParentFile().mkdirs();

			PrintWriter writer = new PrintWriter(file);

			for (Address address : addresses) {
				writer.println(toLine(address));
			}

			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Address> load() throws AddressFileException {
		ArrayList<Address> addressList = new ArrayList();

		try {
			BufferedReader in = new BufferedReader(new FileReader(this.filename));

			while (in.ready()) {
				String line = in.readLine();
				Address address = parseLine(line);
				addressList.add(address);
			}

			in.close();
		} catch (FileNotFoundException e) {
			throw new AddressFileException("ERROR: Input file not found.");
		} catch (IOException e) {
			throw new AddressFileException("ERROR: Load failed. " + e.getMessage());
		}

		return addressList;
	}

}