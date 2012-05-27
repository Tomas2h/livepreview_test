package test_util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadFile {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws Exception {
		final File key = new File("sauce.key");
		final byte[] data = new byte[(int) key.length()];
		DataInputStream dis = new DataInputStream(new FileInputStream(key));
		dis.readFully(data);
		dis.close();

		System.out.println(new String(data).trim());

	}

}
