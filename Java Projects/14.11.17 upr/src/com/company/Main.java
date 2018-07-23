package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        //prosto s placeholders
        String name = "Петър Петров Иванов";
        float expectedSalary = 3000.559f;
        int age = 44;
        System.out.printf("Очаквана стойност: %.2f lv.\n", expectedSalary);
        System.out.printf("Име: %s\nВъзраст:%d\n", name, age);
        */
        /*
        Scanner input = new Scanner(System.in);
        int age;

        System.out.print("Име: ");
        String name = input.nextLine();

        System.out.printf("Hello, %s! ", name);
        System.out.print("How old are you? ");
        age = Integer.parseInt(input.nextLine());
        System.out.printf("You are %d y-o", age);
        System.out.printf("You are %d y-o", age++);
        System.out.printf("You are %d y-o", ++age);
        */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(scanner.nextLine());
        String Number = String.valueOf(num);
        boolean condition = (Number.length() >= 3)&&(Number.charAt(Number.length() - 3) == '7');
        String result = condition?"The third digit from right to left is 7":"The third digit from right to left isn't 7";
        System.out.println(result);
    }
}
