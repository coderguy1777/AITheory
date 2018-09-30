package com.company;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class FileScanner {
    public String test;

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data.txt")));
            ArrayList<Integer> dataset = new ArrayList<>();
            ArrayList<Double> Coordinates = new ArrayList<>();
            while(scan.hasNextLine()) {
                int ClassNumber = scan.nextInt();
                double Coordinate1 = scan.nextDouble();
                double Coordinate2 = scan.nextDouble();

                if (ClassNumber == 0) {
                    dataset.add(ClassNumber);
                    dataset.add(ClassNumber);
                }
                if(ClassNumber == 1) {
                    dataset.add(ClassNumber);
                    dataset.add(ClassNumber);
                }

                if(ClassNumber == 0) {
                    Coordinates.add(Coordinate1);
                    Coordinates.add(Coordinate2);
                }
                if(ClassNumber == 1){
                    Coordinates.add(Coordinate1);
                    Coordinates.add(Coordinate2);
                }
                if(scan.nextLine() != null) {
                    DataSetReadingConfirmation();
                    break;
                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void DataSetReadingConfirmation() {
        String a = "Data has been read";
        System.out.println(a);
    }
}