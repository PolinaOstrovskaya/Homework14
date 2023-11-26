import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\Homework14\\romeo-and-juliet.txt");
        try (FileReader fr = new FileReader(file)) {
            int i;
            StringBuilder newLine = new StringBuilder();
            while ((i = fr.read()) != -1) {
                newLine.append((char) i);
            }
            String[] result = newLine.toString().split("[^A-z]");
            Arrays.sort(result, Comparator.comparing(String::length));
            File fileResult = new File("F:\\Homework14\\LongestWord.txt");
            try (FileWriter fw = new FileWriter(fileResult)) {
                fw.write(result[result.length - 1]);
                System.out.println("Longest word is written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (RuntimeException e) {
            System.out.println("Exception is found " + e);
        }
    }
}






