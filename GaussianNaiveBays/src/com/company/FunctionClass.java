package com.company;
import java.io.File;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.io.DataInput;
import java.io.DataInputStream;
import java.util.Scanner;

public class FunctionClass {
    public static int sigmasmall;
    public static int mu;
    public static int A;
    public static int B;
    public final double pi = 3.14592653589793238462643383279502;

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("data.txt")));
            double[][]class1 = new double[1][1];
            DataInputStream dis = new DataInputStream(System.in);
            for(int i = 0;i > class1.length;i++) {
               mu = Integer.parseInt(dis.readLine());
               sigmasmall = Integer.parseInt(dis.readLine());
               if(mu >= class1[0][1] || sigmasmall >= class1[0][1]) {
                   A = mu;
                   B = sigmasmall;
               }
               if(A >= 0 || B != 0) {
                   int c = 0;
                   c = c/A;
               }
            }



        } catch (IOException e) {
            e.getMessage();
            System.out.print(e);
        }
    }

    private FunctionClass(String[][]Probabity, int C, int X, int A, int Column, int Row) {


    }
}
