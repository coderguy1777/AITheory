/*
        A Program that does Gaussian Naive bayes for a given set of data with the goal of doing
        Gaussian Naive Bayes to find the Probability of the point itself being in the dataset.
        By @Jordan Hill
        Period for doing AI Theory: F Period.
        */

//All the Imports I used for the project of doing Gaussian Naive Baye Heuristics.

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class GaussianNaiveBayes {
    //All the Static Arrays I used for Storing Points and User input for the program to use later on.
    private static ArrayList<ArrayList<Double>> dataset = new ArrayList<>();
    private static ArrayList<Double> YCoordinates = new ArrayList<Double>();
    private static ArrayList<Double> XCoordinatess = new ArrayList<Double>();
    private static ArrayList<Integer> ClassValues = new ArrayList<>();
    private static double[] ClassArray;

    //All the Static Integers and Doubles I used for my Program when making it.
    private static int trueclassnumber; //Prints Class Value.
    private static Double Coordinate1; //Value for Storing X Coordinates.
    public static Double Coordinate2; //Value for Storing Y Coordinates.
    public static Double meanforx;
    public static Double meanfory;
    private static double VarianceX;
    private static double VarianceY;
    private static double xvalue1; //Value for the User input for the X Points to be used to calculate the final probability.
    private static double yvalue2; //Value for the User input for the Y Points to be used to calculate the final probability.
    private static Double BottomHalfofFormulaforY;
    private static Double BottomHalfofFormulaforX;
    private static Double ExponentofFormulaforX;
    private static Double FinalformulaX;
    private static Double ClassXProbability;
    private static Double Finalformulay;
    private static Double ClassYProbabilityY;
    private static Double ExponentofFormulaY;
    private static double Cvalue;
    private static double XCvalue;
    private static double YCvalue;
    private static double ClassProbability;
    private static double sumofx;
    private static double sumofy;
    private static int count = 0;


    public static void main(String[] args) {
        UserInput();
    }

    private static void DataSetReadingConfirmation() {
        String a = "Data has been read";
        System.out.println(a);
    }

    private static ArrayList<ArrayList<Double>> DataReader() {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data")));
            dataset = new ArrayList<>();
            XCoordinatess = new ArrayList<Double>();
            while (scan.hasNext()) {
                trueclassnumber = scan.nextInt();
                if (dataset.size() < trueclassnumber + 1) {
                    dataset.add(new ArrayList<>(count));
                    count++;
                }
                Coordinate1 = scan.nextDouble();
                Coordinate2 = scan.nextDouble();
                dataset.get(trueclassnumber).add(Coordinate1);
                dataset.get(trueclassnumber).add(Coordinate2);

                XCoordinatess.add(Coordinate1);
                YCoordinates.add(Coordinate2);
                for (Double XCoordinates : XCoordinatess) {
                    sumofx = 0;
                    while(sumofx < XCoordinatess.size()) {
                        sumofx += XCoordinatess.get(trueclassnumber);
                        meanforx = sumofx / XCoordinatess.size();
                    }
                }
            }

            for (Double YCoordinate : YCoordinates) {
                sumofy = 0;
                while(sumofy < YCoordinates.size()) {
                    sumofy += YCoordinates.get(trueclassnumber);
                    meanfory = sumofy / YCoordinates.size();
                }
            }

            double variancex = 0;
            VarianceX = 0;
            for (int i = 0; i < XCoordinatess.size(); i++) {
                double pointvalue = XCoordinatess.get(i);
                double meanforxx = meanforx;
                variancex = Math.pow((pointvalue * 1.0 - meanforxx), 2);
                VarianceX = VarianceX + variancex;
            }

            VarianceX = VarianceX / (XCoordinatess.size() - 1);
            double variance = 0;
            VarianceY = 0;
            for (int i = 0; i < YCoordinates.size(); i++) {
                double pointvalue = YCoordinates.get(i);
                double meanforyy = meanfory;
                variance = Math.pow((pointvalue * 1.0 - meanforyy), 2);
                VarianceY += variance;
            }

            VarianceY = VarianceY / (YCoordinates.size() - 1);

            BottomHalfofFormulaforX = 1 / Math.sqrt(2 * 3.14 * meanforx);
            ExponentofFormulaforX = Math.pow(xvalue1 - VarianceX, 2) / 2 * VarianceX;
            FinalformulaX = BottomHalfofFormulaforX * ExponentofFormulaforX;

            BottomHalfofFormulaforY = 1 / Math.sqrt(2 * 3.14 * meanfory);
            ExponentofFormulaY = Math.pow(yvalue2 - VarianceY, 2) / 2 * VarianceY;
            Finalformulay = BottomHalfofFormulaforY * ExponentofFormulaY;

            Cvalue = XCoordinatess.size() + YCoordinates.size();
            double twocvalue = Cvalue / 2;
            XCvalue = FinalformulaX / meanforx / VarianceX;
            YCvalue = Finalformulay / meanfory / VarianceY;

            count = 0;
            for(int i = 0; i < dataset.size(); i++) {
                count = i + 1;
                System.out.println("Class" + " " + (count - 1) + ": " + twocvalue / XCvalue / YCvalue );
                if(count < 0) {
                    break;
                }
            }
            if (!scan.hasNext()) {
                DataSetReadingConfirmation();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void UserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter X:");
        xvalue1 = scan.nextDouble();
        System.out.println("You entered:" + " " + xvalue1 + "for x, now please enter Y.");
        yvalue2 = scan.nextDouble();
        System.out.println("You entered:" + " " + xvalue1 + "," + yvalue2 + " " + "for both points for the Gaussian Naive bayes to Solve for, please confirm this is correct, by typing Y or N.");
        String Input = scan.next();
        if (Input.equals("Y")) {
            System.out.println("The Program will now calculate the probability that your points exist, please wait while this is done.");
            DataReader();
        } else if (Input.equals("N")) {
            System.out.println("The Program will now end.");
            boolean endinput = true;
            while (endinput) {
                break;
            }
        } else if (Input.equals("y")) {
            System.out.println("The Program will now calculate the probability of your points.");
            DataReader();
        } else if (Input.equals("n")) {
            boolean endinput = true;
            while (endinput) {
                break;
            }
        }
    }
}