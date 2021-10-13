package zetthard.lesson2;

import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {

        //printOdd();
        //fizzBuzzOption();
        //System.out.println(checkSum());
        //System.out.println(checkOrderAsc());
    }

    //2.1
    public static void printOdd() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    //2.2
    public static void fizzBuzzOption() {

        String three = "Делятся на три: ";
        String five = "Делятся на пять: ";
        String threeAndFive = "Делятся и на три и на пять: ";

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                threeAndFive += i + ", ";
            } else if (i % 3 == 0) {
                three += i + ", ";
            } else if (i % 5 == 0) {
                five += i + ", ";
            }
        }

        System.out.println(three);
        System.out.println(five);
        System.out.println(threeAndFive);
    }

    //2.3
    public static boolean checkSum() {

        int num1, num2, num3;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое целое число: ");
        num1 = sc.nextInt();
        System.out.println("Введите второе целое число: ");
        num2 = sc.nextInt();
        System.out.println("Введите третье целое число: ");
        num3 = sc.nextInt();

        return num1 + num2 == num3;
    }

    //2.4
    public static boolean checkOrderAsc() {

        int num1, num2, num3;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое целое число: ");
        num1 = sc.nextInt();
        System.out.println("Введите второе целое число: ");
        num2 = sc.nextInt();
        System.out.println("Введите третье целое число: ");
        num3 = sc.nextInt();

        return num3 > num2 && num2 > num1;
    }
}
