package first;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TexttoFile {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence to convert it into text file");
		String input = sc.nextLine();
		  String filePath = "C:\\Users\\Dell\\OneDrive\\Desktop\\output.txt";
	        
		FileWriter writer = new FileWriter(filePath);
		 writer.write(input);
	        writer.close();

	        System.out.println("Text written to the file.");
		
		
		
		
	}

}
