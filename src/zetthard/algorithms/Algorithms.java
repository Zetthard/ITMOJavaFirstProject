package zetthard.algorithms;

import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {

        //tests
        int[] array1 = { 12, 23, 34, 45, 56, 67, 78, 89, 90 };
        int[] array2 = { 12, 23, 34, 45, 100, 56, 67, 78, 89, 90 };
        int[] array3 = { 200, 12, 23, 34, 45, 100, 56, 67, 78, 89, 90 };
        int arr1Sum = sumRec(array1);
        System.out.println(arr1Sum);
        System.out.println();
        System.out.println(countElmntsRec(array1));
        System.out.println();
        System.out.println(getLargestIter(array1));
        System.out.println(getLargestIter(array2));
        System.out.println(getLargestIter(array3));
        System.out.println();
        System.out.println(getLargestRec(array1));
        System.out.println(getLargestRec(array2));
        System.out.println(getLargestRec(array3));
    }

    //4.1 recursive sum algo
    public static int sumRec (int[] arr) {

        int first = arr[0];
        int[] rest = Arrays.copyOfRange(arr, 1, arr.length);
        if (arr.length == 1) {
            return first;
        } else { return sumRec(rest) + first; }
    }

    //4.2 recursive counting elements
    public static int countElmntsRec(int[] arr) {

        //I don't understand in what way this exercise makes sense
        int res;
        int len = arr.length;
        if (len == 0) {
            res = 0;
        } else if (len == 1) {
            res = 1;
        }
        else {
            int[] rest = Arrays.copyOfRange(arr, 1, arr.length);
            res = 1 + countElmntsRec(rest);
        }
        return res;
    }

    //4.3a finding largest iterative
    public static int getLargestIter (int[] arr) {

        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    //4.3a finding largest recursive
    public static int getLargestRec (int[] arr) {

        int largest;
        int first = arr[0];
        if (arr.length == 1) {
            largest = first;
        } else {
            int[] rest = Arrays.copyOfRange(arr, 1, arr.length);
            int last = getLargestRec(rest);
            largest = first > last ? first : last;
        }
        return largest;
    }
}

