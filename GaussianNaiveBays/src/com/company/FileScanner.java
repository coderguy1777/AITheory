package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class FileScanner {
    private static ArrayList<Double> Coordinates = new ArrayList<Double>();
    private static ArrayList<Double> dataset = new ArrayList<Double>();
    private static ArrayList<Double> XCoordinatess = new ArrayList<Double>();
    private static int trueclassnumber;
    public static double Coordinate1;
    public static double Coordinate2;
    public static ArrayList<Integer>XandYPointStorage = new ArrayList<Integer>();
    public static ArrayList<Double>YCoordinates = new ArrayList<Double>();

    private static double Variance;
    public static Integer[]XandYArray;
    public static Double[]dataSetArray;
    public static Double[]XCoordinates;
    public static Double[]YCoordinatess;
    public static Double[]xtemp;

    public static void main(String[] args) {
        UserInput();
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
                trueclassnumber = scan.nextInt();

                if (dataset.size() < trueclassnumber + 1) {
                    dataset.add(new ArrayList<Double>());
                    Coordinates.add(new ArrayList<Integer>());

                }
                Coordinate1 = scan.nextDouble();
                Coordinate2 = scan.nextDouble();

                dataset.get(trueclassnumber).add(Coordinate1);
                dataset.get(trueclassnumber).add(Coordinate2);
                XCoordinatess.add(Coordinate1);
                YCoordinates.add(Coordinate2);
                System.out.println(trueclassnumber + " " + Coordinate1 + " , " + Coordinate2);

                while(!scan.hasNext()) {
                    DataSetReadingConfirmation();
                    break;
                }
                FinalFunction();


            }
            return dataset;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Double> getCoordinates() {
        return Coordinates;
    }

    public static void setCoordinates(ArrayList<Double> coordinates) {
        Coordinates = coordinates;
    }

    private ArrayList<ArrayList<Double>> ClassValue(double[]ClassStorageSize) {
        Scanner scan;
        scan = new Scanner(System.in);
        int ClassSize = scan.nextInt();

        for(double i = trueclassnumber - 1; i < ClassStorageSize.length;i++) {
            if(ClassSize <= trueclassnumber - 1) {
                double ClassSizeStore;
                dataset = new ArrayList<>();
                ClassSizeStore = dataset.get(trueclassnumber - 1);
                dataset.add(ClassSizeStore);
            }
            if(ClassSize == trueclassnumber) {
                double ClassSizeStore2;
                dataset = new ArrayList<>();
                ClassSizeStore2 = dataset.get(trueclassnumber - 1 + 1);
                dataset.add(ClassSizeStore2);
            }
        }
        return null;
    }

    private ArrayList<ArrayList<Double>> Variance() {
        return null;
    }

    public static void setDataset(ArrayList<Double> dataset1) {
        dataset = dataset1;
    }

    public static ArrayList<Double>getDataset() {
        return dataset;
    }

    public static ArrayList<ArrayList<Integer>>UserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter X:");
        int x = scan.nextInt();
        XandYPointStorage.add(x);
        System.out.println("You entered:" + x + "for x, now please enter Y.");
        int y = scan.nextInt();
        XandYPointStorage.add(y);
        System.out.println("You entered:" + x + "," + y + "for both points for the Gaussian Naive bayes to Solve for, please confirm this is correct, by typing Y or N.");
        String Input = scan.next();
        if(Input.equals("Y")) {
            System.out.println("The Program will now calculate the probability that your points exist, please wait while this is done.");
            FileReader();
        }
        else if(Input.equals("N")) {
            System.out.println("The Program will now end.");
            boolean endinput = true;
            while(endinput) {
                break;
            }
        }
        else if(Input.equals("y")) {
            System.out.println("The Program will now calculate the probability of your points.");
            FileReader();
        }
        else if(Input.equals("n")) {
            boolean endinput = true;
            while (endinput) {
                break;
            }
        }

        XandYPointStorageArray();
        System.out.println(XandYPointStorage);

        return null;
    }

    private static ArrayList<ArrayList<Double>> MeanofUserInput() {
        return null;
    }

    private static ArrayList<ArrayList<Double>> Average() {
        return null;
    }

    private static int[] XandYPointStorageArray() {
        XandYArray = new Integer[XandYPointStorage.size()];
        for(int i = 0; i < XandYPointStorage.size(); i++) {
            XandYArray[i] = XandYPointStorage.get(i);
            for(Integer x : XandYArray) {
                System.out.println(x);
            }
        }
        int x = 0;
        return null;
    }

    private static Double[] datasetArray() {
        dataSetArray = new Double[dataset.size()];
        for(int x = 0; x < dataset.size(); x++) {
            dataSetArray[x] = dataset.get(x);
            for(Double i : dataSetArray) {
                System.out.println(i);
            }
        }
        return dataSetArray;
    }

    private static double[] FormulaforNaiveBayesWithXCoordinates() {

        xtemp = new Double[XCoordinatess.size()];
        for(int i = 0; i < XCoordinatess.size(); i ++) {
            xtemp[0] = XCoordinatess.get(i);
            while(i < xtemp.length) {
                Variance = xtemp[0] * 2;
                break;
            }
        }
        return null;
    }


    private static double[]XCoordinateArray() {
        XCoordinates = new Double[XCoordinatess.size()];
        for(int i = 0; i < XCoordinatess.size(); i++) {
            XCoordinates[i] = XCoordinatess.get(i);
            for(Double x : XCoordinates) {
                System.out.println(x);
                while (XCoordinates[i] != null) {
                    System.out.println(x);
                }
            }

        }
        return null;
    }

    private static double[]YCoordinateArray() {
        YCoordinatess = new Double[YCoordinates.size()];
        for(int i = 0; i < YCoordinates.size(); i++) {
            YCoordinatess[i] = YCoordinates.get(i);
            for(Double y : YCoordinatess) {
                System.out.println(y);
                while(YCoordinatess[i] != null) {
                    System.out.println(y);
                }
            }
        }
        return null;
    }

    public static void FinalFunction() {
        FormulaforNaiveBayesWithXCoordinates();
        System.out.println(Variance);
    }
}