// Andy Yeung
// 9/25/2018

import java.util.Scanner;

public class Student {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age:");
        int age = input.nextInt();

        if (age < 13) {
            System.out.println("You are young.");
        } else if (age < 20) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are an adult.");
        }


        String color;
        boolean x = false;
        do {
            System.out.print("What is your favorite color?");
            color = input.next();
            String color2 = " ";
            switch (color) {
                case "green":
                    color2 = "Color of the Nature!";
                    x = true;
                    break;
                case "blue":
                    color2 = "Color of the Sky!";
                    x = true;
                    break;
                case "yellow":
                    color2 = "Color of the Sun!";
                    x = true;
                    break;
                case "red":
                    color2 = "Color of the Rose!";
                    x = true;
                    break;
                case "orange":
                    color2 = "Color of the Tiger!";
                    x = true;
                    break;
                case "pink":
                    color2 = "Color of the Spring!";
                    x = true;
                    break;
                case "grey":
                    color2 = "Color of the Brain!";
                    x = true;
                    break;
                default:
                    System.out.println("Invalid color! Pick again.");
                    break;
            }
            System.out.println(color2);
        }
        while (!x);


        int a = 0;
        int b = 1;
        double n;
        boolean y = false;
        System.out.println("Pick a number:");
        int m = input.nextInt();
        while (!y) {
            if (Math.pow(2, a) < m && m < Math.pow(2, b)) {
                y = true;
            } else {
                a++;
                b++;
                y = false;
            }
        }
        n = Math.pow(2, a);
        System.out.printf("Smallest power of 2 to %d is %.1f(2^%d)", m, n, a);
        if (n < 100) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    double fij = (Math.pow((n / 2 - i), 2) + Math.pow((n / 2 - j), 2));
                    if (Math.pow(fij, (0.5)) < (n / 2)) {
                        System.out.print("  *");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }

    }
}

