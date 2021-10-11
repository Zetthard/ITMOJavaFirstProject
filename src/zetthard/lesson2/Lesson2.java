package zetthard.lesson2;

import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();

        switch (name) {
            case "Semen":
                System.out.println("Hi, " + name);
                break;
            case "Anna":
                System.out.println("Hello, " + name);
                break;
            default:
                System.out.println("Yo, " + name);
        }
        System.out.println(countApples(15, 4));

        String str2 = "java";
        String str1 = new String("Java!");
        String str3 = "java";
        str2 = "hoho";

        System.out.println(str3);
    }

    public static int countApples(int weight, int age) {
        return weight/2 + age;
    }
}
