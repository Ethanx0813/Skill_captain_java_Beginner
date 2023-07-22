package firstpackage;

import java.util.HashMap;
import java.util.Scanner;

public class first {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the text");
		 String a = sc.nextLine();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0;i<a.length();i++) {
			char c = a.charAt(i);
			map.put(c, map.getOrDefault(c,0)+1);
			
			
		} System.out.print(map);
		
		

	}

}
