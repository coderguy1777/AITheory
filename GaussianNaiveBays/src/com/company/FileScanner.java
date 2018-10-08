package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class FileScanner {
    private static Integer[] XandYArray;
    private static Double[] dataSetArray;
    private static Double[] XCoordinates;
    private static Double[] YCoordinatess;
    private static Double[] xtemp;
    private static ArrayList<Double> Coordinates = new ArrayList<Double>();
    private static ArrayList<Double> dataset = new ArrayList<Double>();
    private static ArrayList<Double> XCoordinatess = new ArrayList<Double>();
    private static ArrayList<Integer> XandYPointStorage = new ArrayList<Integer>();
    private static ArrayList<Double> YCoordinates = new ArrayList<Double>();

    private static int trueclassnumber;
    private static double Coordinate1;
    private static double Coordinate2;
    private static double SumofX;
    public static double MeanofXCoordinates;
    private static double VarianceofXCoordinates;
    private static double AverageofXCoordinates;
    private static double SumofY;
    public static double MeanofYCoordinates;
    private static double VarianceofYCoordinates;
    private static double AverageofYCoordinates;
    private static double MeanofEntireTrainingDataSet;


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

                while (!scan.hasNext()) {
                    DataSetReadingConfirmation();
                    break;
                }
                BackFunctions();
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

    private ArrayList<ArrayList<Double>> ClassValue(double[] ClassStorageSize) {
        Scanner scan;
        scan = new Scanner(System.in);
        int ClassSize = scan.nextInt();

        for (double i = trueclassnumber - 1; i < ClassStorageSize.length; i++) {
            if (ClassSize <= trueclassnumber - 1) {
                double ClassSizeStore;
                dataset = new ArrayList<>();
                ClassSizeStore = dataset.get(trueclassnumber - 1);
                dataset.add(ClassSizeStore);
            }
            if (ClassSize == trueclassnumber) {
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

    public static ArrayList<Double> getDataset() {
        return dataset;
    }

    public static ArrayList<ArrayList<Integer>> UserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter X:");
        int x = scan.nextInt();
        XandYPointStorage.add(x);
        System.out.println("You entered:" + x + "for x, now please enter Y.");
        int y = scan.nextInt();
        XandYPointStorage.add(y);
        System.out.println("You entered:" + x + "," + y + "for both points for the Gaussian Naive bayes to Solve for, please confirm this is correct, by typing Y or N.");
        String Input = scan.next();
        if (Input.equals("Y")) {
            System.out.println("The Program will now calculate the probability that your points exist, please wait while this is done.");
            FileReader();
        } else if (Input.equals("N")) {
            System.out.println("The Program will now end.");
            boolean endinput = true;
            while (endinput) {
                break;
            }
        } else if (Input.equals("y")) {
            System.out.println("The Program will now calculate the probability of your points.");
            FileReader();
        } else if (Input.equals("n")) {
            boolean endinput = true;
            while (endinput) {
                break;
            }
        }

        System.out.println(XandYPointStorage);
        return null;
    }

    private static ArrayList<ArrayList<Double>> MeanofUserInput() {
        return null;
    }

    private static ArrayList<ArrayList<Double>> Average() {
        return null;
    }

    private static void XandYPointStorageArray() {
        XandYArray = new Integer[XandYPointStorage.size()];
        for (int i = 0; i < XandYPointStorage.size(); i++) {
            XandYArray[0] = XandYPointStorage.get(i);
            XandYArray[1] = XandYPointStorage.get(i);
        }

    }

    private static Double[] datasetArray() {
        dataSetArray = new Double[dataset.size()];
        for (int x = 0; x < dataset.size(); x++) {
            dataSetArray[x] = dataset.get(x);
            for (Double i : dataSetArray) {
                System.out.println(i);
            }
        }
        return dataSetArray;
    }

    private static double[] FormulaforNaiveBayesWithXCoordinates() {

        xtemp = new Double[XCoordinatess.size()];
        for (int i = 0; i < XCoordinatess.size(); i++) {
            xtemp[0] = XCoordinatess.get(i);
            while (i < xtemp.length) {
                break;
            }
        }
        return null;
    }


    private static void XCoordinateArray() {
        XCoordinates = new Double[XCoordinatess.size()];
        for (int i = 0; i < XCoordinatess.size(); i++) {
            XCoordinates[i] = XCoordinatess.get(i);
        }
    }

    private static void YCoordinateArray() {
        YCoordinatess = new Double[YCoordinates.size()];
        for (int i = 0; i < YCoordinates.size(); i++) {
            YCoordinatess[i] = YCoordinates.get(i);
        }
    }

    private static void BackFunctions() {
        XandYPointStorageArray();
        XCoordinateArray();
        YCoordinateArray();
        SumofXFramework();
        SumofYFramework();
        MeanofXCoordinatesFramework();
        MeanofYCoordinatesFramework();
    }

    private static double SumofXFramework() {
        SumofX = 0;
        for (int i = 0; i < XCoordinates.length; i++) {
            SumofX += XCoordinates[i];
        }
        return SumofX;
    }


    private static double SumofYFramework() {
        SumofY = 0;
        for (int i = 0; i < YCoordinatess.length; i++) {
            SumofY += YCoordinatess[i];
        }
        return SumofY;
    }

    private static void MeanofXCoordinatesFramework() {
        int i = 1;
        MeanofXCoordinates = SumofX/4 * i;
    }

    private static void MeanofYCoordinatesFramework() {
        int i = 1;
        MeanofYCoordinates = SumofY/4 * i;
    }

    private static void MeanValueoftheDataSet() {
        int holder = 0;
    }

    private static double VarianceFramworkForXCoordinates() {
        return VarianceofXCoordinates;
    }

    private static double VarianceFrameworkForYCoordinates() {
        return VarianceofYCoordinates;
    }

    private static double AverageofXCoordinates() {
        return AverageofXCoordinates;
    }

    private static double AverageofYCoordinates() {
        return AverageofYCoordinates;
    }

    private static void ProbabilityforXUserinput() {
        int holder = 0;
    }

    private static void ProbabilityforYUserinput() {
        int holder = 0;
    }

    private static void Class0Probability() {
        int holderr = 0;
    }

    private static void Class1Probability() {
        int holdeerrr = 0;
    }

    private static void Class2Probability() {
        int holdeeerrrr = 0;
    }
}