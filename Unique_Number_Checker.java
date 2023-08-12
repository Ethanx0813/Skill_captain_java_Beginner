package First;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique_Number_Checker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Unique Number Checker");
       

        System.out.print("Enter the numbers you want to check ");
        String s = sc.nextLine();

        String[] numberStrings = s.split("\\s+");

        HashSet<Object> uniqueNumbers = new HashSet<>();

        System.out.println("\nNumber\t\tStatus");
        System.out.println("------------------------");

        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString);

            if (uniqueNumbers.contains(number)) {
                System.out.println(number + "\t\tDuplicate");
            } else {
                uniqueNumbers.add(number);
                System.out.println(number + "\t\tUnique");
            }
        }

        sc.close();
		

	}

}
