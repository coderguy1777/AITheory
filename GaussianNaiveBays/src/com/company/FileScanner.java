package com.company;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class FileScanner {

    public static void main(String[] args) {
        FileReader();
    }

    private static void DataSetReadingConfirmation() {
        String a = "Data has been read";
        System.out.println(a);
    }

    private static ArrayList<ArrayList<Double>> FileReader() {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data.txt")));
            ArrayList<ArrayList<Integer>> Coordinates = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Double>> dataset = new ArrayList<ArrayList<Double>>();

            while (scan.hasNext()) {
                int trueclassnumber = scan.nextInt();

                if (dataset.size() < trueclassnumber + 1) {
                    dataset.add(new ArrayList<Double>());
                    Coordinates.add(new ArrayList<Integer>());

                }
                double Coordinate1 = scan.nextDouble();
                double Coordinate2 = scan.nextDouble();

                dataset.get(trueclassnumber).add(Coordinate1);
                dataset.get(trueclassnumber).add(Coordinate2);


                System.out.println(dataset);
                while(!scan.hasNext()) {
                    DataSetReadingConfirmation();
                    break;
                }


            }
            return dataset;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<ArrayList<Double>> ClassValue() {
        return null;
    }

    private static int Variance(int x) {
        return x;
    }

    public static int UserInput(int y) {
        return y;
    }

    private static ArrayList<ArrayList<Double>> MeanofUserInput() {
        return null;
    }

    private static ArrayList<ArrayList<Double>> Average() {
        return null;
    }
}