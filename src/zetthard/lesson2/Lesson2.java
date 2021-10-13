package zetthard.lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {

        //2.1 test
        //printOdd();

        //2.2 test
        //fizzBuzzOption();

        //2.3 test
        //System.out.println(checkSum());

        //2.4 test
        //System.out.println(checkOrderAsc());

        int[] arr1 = { 0, 3, 5, -3, 94, 3 };
        System.out.println(Arrays.toString(arr1));
        //2.5 test
        //System.out.println(containsNumber(arr1, 3));
        //2.6 test
        //System.out.println(containsNumbers(arr1, 1, 3));
    }

    //2.1
    public static void printOdd() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
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

    //2.5
    public static boolean containsNumber(int[] arr, int val) {

        return (arr[0] == val || arr[arr.length-1] == val);
    }

    //2.6
    public static boolean containsNumbers(int[] arr, int val1, int val2 ) {

        boolean res = false;
        int[] vals = { val1, val2 };

        for (int var :
                vals) {
            if (arr[0] == var || arr[arr.length - 1] == var) {
                res = true;
                break;
            }
        }
        return res;
    }
}
