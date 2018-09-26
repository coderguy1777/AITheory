import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;

public class FileScanner {
    public static int XInput;
    public static int YInput;
    public static int FileArray[][] = new int[100][100];
    public static int Coordinate1;
    public static int Coordinate2;

    public static void main(String[] args) {
        List<DataSetReader> Double = new ArrayList<>();
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
        String input = inputscanner.next();
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