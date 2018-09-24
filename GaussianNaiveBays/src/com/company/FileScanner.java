import java.util.Scanner;
import java.io.*;

public class FileScanner {
    public static void main(String[] args) {
        try {
            Scanner scan1 = new Scanner(new BufferedReader(new FileReader("data.txt")));
            double a = scan1.nextDouble();
            double b;
            double[]datastorage = new double[6];
            datastorage[0] = scan1.nextDouble();
            datastorage[1] = scan1.nextDouble();
            datastorage[2] = scan1.nextDouble();
            datastorage[3] = scan1.nextDouble();
            datastorage[4] = scan1.nextDouble();
            for(b = a; b <= datastorage.length;) {
                System.out.println(b + "," + scan1.nextDouble());
            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}