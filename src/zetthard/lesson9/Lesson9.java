package zetthard.lesson9;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Lesson9 {
    public static void main(String[] args) {

        int[][] arr1 = { {2, 4, 7}, {3, 8, 5}, {2, 4, 6} };
        int[][] arr2 = { {2, 4, 7}, {3, 8, 5} };
        int[][] arr3 = new int[0][0];

        //9.1 test
        System.out.println(getLargestIn2dArr(arr1));
        System.out.println(getLargestIn2dArr(arr3));

        //9.2 test
        System.out.println(checkIfSquare(arr1));
        System.out.println(checkIfSquare(arr2));

        //9.3 test
        StringBuilder sb1 = new StringBuilder("{ ");
        for (int num :
                getLargestRow(arr1)) {
            sb1.append(num).append(", ");
        }
        sb1.deleteCharAt(sb1.length()-2).append("}");
        System.out.println(sb1);

        //9.4 test
        /*int m = 0, n = 0;
        Scanner scanner= new Scanner(System.in);
        try {
            System.out.println("Enter number of rows: ");
            m = scanner.nextInt();
            System.out.println("Enter number of elements in a row: ");
            n = scanner.nextInt();
            char [][] arr4 = makeCharArray(m, n);
            for (char[] chars:
                    arr4){
                for (char ch :
                        chars) {
                    System.out.print(ch + " ");
                }
                System.out.println();
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Integer required. Method 9.4 was not called");
        }*/

        //9.5 test
        int[] numbers = {4, 15, 8, 9, 13, 3};
        int[] weights = {3, 6, 9, 12, 15, 18};
        System.out.println(getMatchingInt(numbers, weights));
    }

    //9.1
    public static int getLargestIn2dArr (int[][] arr) {
        int max = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }

    //9.2
    public static boolean checkIfSquare (int[][] arr) {
        return arr.length == arr[0].length;
    }

    //9.3
    public static int[] getLargestRow (int[][] arr) {
        int max = 0;
        int row = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum > max) {
                max = sum;
                row = i;
            }
        }
        return arr[row];
    }

    //9.4
    public static char[][] makeCharArray(int m, int n) {
        char[][] arr = new char[m][n];
        Random rnd = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (char) rnd.nextInt('a', 'z'+1);
            }
        }
        return arr;
    }

    //9.5
    public static int getMatchingInt (int[] numbers, int[] weights) {
        List<Integer> matched = new ArrayList<>();
        Random rnd = new Random();
        for (int n :
                numbers
             ) {
            for (int w :
                    weights) {
                if (n == w) {
                    matched.add(n);
                }
            }
        }
        int index = rnd.nextInt(0, matched.size());
        return matched.get(index);
    }
}
