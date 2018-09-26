import java.io.File;
import java.io.*;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.HashSet;
import java.io.StringReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class FunctionClass {

    public static int mu_var;
    public int smallsigma_var;
    public boolean A;
    public boolean B;
    public int eplision_var;
    public String a;
    public String b;
    public final double MIN_VALUE_OF_STRING = 0.01;
    public final double MAX_VALUE_OF_STRING = 1;
    public static double DataScan;


    public static void main(String[] args) {

        Scanner scan;
        DataSetReader DataTest = new DataSetReader();

        try {
            FileReader reader = new FileReader("Data.txt");
            double Character;
            while ((Character = reader.read()) != -1) {
                System.out.print((char) (Character));
            }
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
