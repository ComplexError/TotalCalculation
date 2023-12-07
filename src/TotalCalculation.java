import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileWriter;

public class TotalCalculation {
    public static void main(String[] args) {
        double subtotal = 0;
        File input = new File("items.txt");
        File output = new File("total.txt");
        try (Scanner sc = new Scanner(new FileInputStream(input))) {
            while (sc.hasNextDouble()) {
                double readDouble = sc.nextDouble();
                subtotal = readDouble + subtotal;
            }
        } catch (IOException e) {

        }

        double tax = subtotal * .053;
        double total = subtotal + tax;

        try {
            output.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileWriter fileWriter = new FileWriter(output);
            fileWriter.write("The subtotal is $" + String.format("%.2f", subtotal) + "\r\n");
            fileWriter.write("The tax is $" + String.format("%.2f", tax) + "\r\n");
            fileWriter.write("The total is $" + String.format("%.2f", total) + "\r\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File should be found...");
        }
    }
}