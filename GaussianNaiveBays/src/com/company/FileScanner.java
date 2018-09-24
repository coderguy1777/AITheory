package com.company;
import java.util.Scanner;
import java.io.*;

public class FileScanner {
    public static void main(String[] args) {
        try {
            Scanner scan1 = new Scanner(new BufferedReader(new FileReader("data.txt")));


            double a = scan1.nextDouble();
            double b = a/2;
            while(scan1.hasNext()) {
                b = a + scan1.nextDouble();
                if(b <= 6.00) {
                    System.out.println("this is class0," + " " + b);

                }
            }


        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}