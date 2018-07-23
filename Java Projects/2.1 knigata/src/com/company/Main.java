package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Radius = ");
        double r = Double.parseDouble(scanner.nextLine());
        System.out.println("Area = " + Math.PI*r*r);
        System.out.println("Perimeter = " + 2*Math.PI*r);
    }
}
