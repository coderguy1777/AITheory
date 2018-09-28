import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FileScanner {
    public static int XInput;
    public static int YInput;
    public static int FileArray[][] = new int[100][100];
    public static int Coordinate1;
    public static int Coordinate2;

    public static void main(String[] args) {
        ArrayList<DataSetReader>Double = new ArrayList<>();
        int i = '0';
        int j = '1';
        String[] ClassClassifierClass0 = new String[i];
        String[] ClassClassifierClass1 = new String[j];
        XandYProbabiltyInput();
        try {
            Scanner scan1 = new Scanner(new BufferedReader(new FileReader("data.txt")));
            while(scan1.hasNext()) {
                String[]tempholder = new String[i/2];
                int XInitial = XInput/2;
                int YInitial = YInput/2;
                int X2 = XInitial * 2;
                int X3 = XInitial * 2;
                int Y2 = YInitial * 2;
                int Y3 = YInitial * 2;
                int[]ClassStorageArray = new int[2];
                while(scan1.hasNextLine()) {
                    int Class0 = 2;
                    int Class1 = 1;
                    int ClassIdentifier = 0;
                    int NoCoordinatesPresent = -1;

                    String ClassScanner = scan1.nextLine();
                    for(int ClassNumber = 0; ClassNumber < ClassScanner.length(); ClassNumber++) {
                        if(ClassScanner.charAt(ClassNumber) == '0') {
                            FileArray[ClassNumber][ClassIdentifier] = Class0;
                            ClassStorageArray[0] = ClassNumber;
                            ClassStorageArray[1] = ClassIdentifier;
                            if(ClassScanner.charAt(ClassNumber) != '0') {
                                System.out.println("No Class 0 Identifying factors have been found in the file given to scan for this program");
                            }
                        }
                        if(ClassScanner.charAt(ClassNumber) == '1') {
                            FileArray[ClassNumber][ClassIdentifier] = Class1;
                            ClassStorageArray[0] = ClassNumber;
                            ClassStorageArray[1] = ClassIdentifier;
                            if(ClassScanner.charAt(ClassNumber) != '1') {
                                System.out.println("No Class 1 Identifiers have been found in the file that was given for this program to scan.");
                            }
                            if(ClassScanner.charAt(ClassNumber) != '0' && ClassScanner.charAt(ClassNumber) != '1') {
                                System.out.println("No Identifiers for any classes of Data have been found in this file that has been scanned, the program will now end.");
                                break;
                            }
                        }
                        if(ClassScanner.charAt(ClassNumber) == ' ') {
                            FileArray[ClassNumber][ClassIdentifier] = NoCoordinatesPresent;
                            System.out.println("Due to a file error and nothing present, nothing could be done with the data file given to scan.");
                            break;
                        }
                    }
                    ClassIdentifier++;

                }
            }
            double CoordinateDecimalFinder = 0.0;
            String CoordinateSpace = scan1.nextLine();
            for(double Coordinates = 0.0; Coordinates < CoordinateSpace.length(); Coordinates++) {
                CoordinateDecimalFinder = 0.0 * 2.1;
                if(CoordinateDecimalFinder >= Coordinates || CoordinateDecimalFinder == Coordinates) {
                    int Class0Coord = 0;
                    int Class0Coord2 = 1;
                    String[][]CoordinateHolderClass0 = new String[Class0Coord][Class0Coord2];
                    for(int Class0Coordinates = 0; Class0Coordinates <= CoordinateHolderClass0.length; Class0Coordinates++) {
                        CoordinateHolderClass0[Class0Coord][Class0Coord2] = CoordinateHolderClass0[Class0Coord+2][Class0Coord2 + 2];
                        int[][]NumberofClass0Coordinates = new int[0][3];


                    }



                }

            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    public static void XandYProbabiltyInput() {
        Scanner inputscanner = new Scanner(System.in);
        System.out.println("Hello! Please Type a number for the input of X.");
        XInput = inputscanner.nextInt();
        System.out.println("Now Please type a Number for the input of Y.");
        YInput = inputscanner.nextInt();
        System.out.println("You typed:" + XInput + "," + YInput + "" + "as your inputs, is this correct? Please type Y or N to say so.");
        String input = inputscanner.next() ;
        boolean Inputendprogram = true;
        while (Inputendprogram == true) {
            if (input == "Y") {
                System.out.println("Thanks for Confirmation, Enjoy the Program.");
            }
            if (input == "N") {
                System.out.println("Alright, thanks for typing inputs anyway, be like that and end the program, fine by me.");
                break;
            }
        }
    }
}