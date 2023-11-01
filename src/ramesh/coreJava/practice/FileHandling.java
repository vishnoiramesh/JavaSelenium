package ramesh.coreJava.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class FileHandling {
	public static void main(String[] args) {
		String[] paths;
		String dirname = "C:/tmp/JavaPractice";
		File dir = new File(dirname); 
		
		// File dir = new File("C:/tmp/JavaPractice");
		
		// Create directory now.
		dir.mkdirs();

		try {
			File file = new File(dirname + "/TestFile1.txt");
			file.createNewFile();
			// array of files and directory
			
			paths = dir.list();
			
			// for each name in the path array
			for (String path : paths) {
				// prints filename and directory name
				System.out.println("Available Files: " + path);
			}
				FileWriter writer = new FileWriter(file);
				// Writes the content to the file
				writer.write("This\n is\n an\n example\n");
				writer.flush();
				//writer.close();
				// Creates a FileReader Object
				FileReader fr = new FileReader(file);
				char[] a = new char[50];
				fr.read(a);
				// reads the content to the array
				for (char c : a)
					System.out.print(c);
				// prints the characters one by one
				fr.close();
				
				// Other Classes:
				
//				BufferedWriter bWriter = new BufferedWriter(file);
				writer.write("Here you can write complete String at a time");
				writer.close();
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}
}
