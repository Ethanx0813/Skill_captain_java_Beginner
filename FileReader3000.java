import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader3000 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Dell\\OneDrive\\Documents\\input.txt");
        Scanner scan = new Scanner(file);
        int javaCount = 0; 

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line); // Print the line
            javaCount += countWordOccurrences(line, "java");
        }

        System.out.println("Number of occurrences of 'java': " + javaCount);
    }

    // Method to count occurrences of a specific word in a given line
    private static int countWordOccurrences(String line, String targetWord) {
        int count = 0;
        String normalizedLine = line.toLowerCase();
        String normalizedTargetWord = targetWord.toLowerCase();
        String[] words = normalizedLine.split("\\W+");
        for (String word : words) {
            if (word.equals(normalizedTargetWord)) {
                count++;
            }
        }
        return count;
    }
}
