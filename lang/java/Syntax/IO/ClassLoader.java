package IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ClassLoader {
	public static Class loadClass(String path) {
		
		try (
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream oi = new ObjectInputStream(fis);
			) {
			Class cl = (Class) oi.readObject();
			return cl;
		} catch(Exception e) {
			System.out.println("Error -- Unable to load class. " + e.toString());
		}
		return null;
	}
}
