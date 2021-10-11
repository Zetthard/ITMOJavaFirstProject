package zetthard.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java.");
        System.out.println();

        double res = (46 + 10) * (10.0 / 3);
        int res2 = 29 * 4 * (-15);
        System.out.println(res);
        System.out.println(res2);
        System.out.println();

        int number = 10500;
        int result1 = (number/10)/10;
        System.out.println(result1);
        System.out.println();

        double d1 = 3.6;
        double d2 = 4.1;
        double d3 = 5.9;
        double doubleResult = d1 * d2 * d3;
        System.out.println(doubleResult);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter int 'a': ");
        int a = sc.nextInt();
        System.out.println("Please enter int 'b': ");
        int b = sc.nextInt();
        System.out.println("Please enter int 'c': ");
        int c = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println();

        if (b % 2 == 1) {
            System.out.println("Нечетное");
        } else if (b % 2 == 0 && b > 100) {
            System.out.println("Выход за пределы диапазона");
        } else {
            System.out.println("Четное");
        }
    }
}
