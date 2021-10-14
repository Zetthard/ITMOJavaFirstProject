package zetthard.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        //3.1 test
        /*
        int[] array1 = {1, 4, -4, 15, -6, 4, -18, 3, 0, 9};
        int[] array2 = { 3, 3, 3, 3, 3 };
        int[] array3 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] array4 = { 1, 2, 3, 4, 5, 6, -1 };
        int[] array5 = { 40, 1, 2, 3, 4, 5, 6 };
        int[] array6 = { 1, 2, 3, 70, 4, 5, 6 };

        System.out.println(sumArrayElements(array1));
        System.out.println(sumArrayElements(array2));
        System.out.println(sumArrayElements(array3));
        System.out.println(sumArrayElements(array4));
        System.out.println(sumArrayElements(array5));
        System.out.println(sumArrayElements(array6));*/

        //3.2 test
        //printArray();

        //3.3 test
        /*int[] array3 = { 1, 2, 3, 4, 5, 6, 7 };
        swapFirstLast(array3);
        System.out.println(Arrays.toString(array3));*/

        //3.4 test
        /*int[] array7 = { 1, 2, 3, 1, 6, 2 };
        int[] array8 = { 1, 2, 1, 2, 5 };
        int[] array9 = { 1, 2, 3, 4 };
        int[] array10 = { 1 };
        System.out.println(Arrays.toString(array7));
        System.out.println(findUnique(array7));
        System.out.println(Arrays.toString(array8));
        System.out.println(findUnique(array8));
        System.out.println(Arrays.toString(array9));
        System.out.println(findUnique(array9));
        System.out.println(Arrays.toString(array10));
        System.out.println(findUnique(array10));*/

        //3.5 test
        //System.out.println(fiboNelement(7));

        //3.6 test
        /*int[] arrayToSort = new int[20];
        int[] arrayToSort2 = { 2, 4, 15, 3, 64, 34, 8, 17, 27 };
        Random rnd = new Random();
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = rnd.nextInt(100);
        }
        System.out.println(Arrays.toString(arrayToSort));
        int[] sortedArray = myMergeSort(arrayToSort);
        System.out.println(Arrays.toString(sortedArray));*/

    }

    //3.1
    public static String sumArrayElements (int[] ints){

        String ans = "";

        //take every element and compare it to next one
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i+1] < ints[i]) {
                ans = "Please try again."; //if only one element is greater than the next one, finish
                break;
            } else { ans = "OK"; }
        }
        return ans;
    }

    //3.2
    public  static void printArray () {

        String res = "Result: ";
        Scanner sc = new Scanner(System.in);

        //request array size from user
        System.out.println("Please enter desired Array length: ");

        //initialize the array of required size
        int length = sc.nextInt();
        int [] arr = new int[length];

        //request array elements from user according to size
        System.out.println("Elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //convert array to string and build up the output text
        String resultAsString =  Arrays.toString(arr);
        System.out.println(res + resultAsString);
    }

    //3.3
    public static void swapFirstLast (int[] arr) {

        int first = arr[0];
        int last = arr[arr.length-1];

        arr[arr.length-1] = first;
        arr[0] = last;
    }

    //3.4
    public static int findUnique (int[] arr) {

        //if there is only one element it's unique. Return it
        if (arr.length == 1) { return arr[0]; }

        //Initialize default helper values
        int value = -1;
        boolean found = false;
        int[] checked = new int[arr.length]; //collection of already checked values

        //take every element
        for (int i = 0; i < arr.length; i++) {

            if (found) { break; } //finish. We found it

            if (Arrays.asList(checked).contains(arr[i])) {
                continue; //skip element if already checked same value
            } else {
                checked[i] = arr[i]; //otherwise, add value to the collection
            }

            //go through remaining elements
            for (int j = 0; j < arr.length; j++) {
                if (j == i) { continue; } //don't compare to itself

                //and compare two elements
                if (arr[j] == arr[i]) {
                    found = false;
                    break; //does not satisfy. Compare to next one
                }

                found = true;
                value = arr[i]; //so far element seems unique
            }
        }
        return value;
    }

    //3.5
    public static int fiboNelement (int n) {

        //first two elements equal 1. Create array and init
        if (n <= 2) { n = 2; }
        int[] fibCollection = new int[n];
        fibCollection[0] = 1;
        fibCollection[1] = 1;

        //fill the collection up to 'n'
        for (int i = 2; i < n; i++) {
            fibCollection[i] = fibCollection[i-1] + fibCollection[i-2];
        }
        return fibCollection[fibCollection.length-1];
    }

    //3.6
    public static int[] myMergeSort (int[] arr) {

        //if array size is less than 2 it's already sorted
        if (arr.length < 2) {
            return arr;
        }

        //split original array in two and initialize both by copying original elements
        int lSize = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, lSize);
        int[] rightArr = Arrays.copyOfRange(arr, lSize, arr.length);

        //recursive call until array size is >= 2
        myMergeSort(leftArr);
        myMergeSort(rightArr);

        //init helper values for indices
        // and declare temporary array of size equal to sum of two smaller arrays
        int l = 0, r = 0, s = 0;
        int[] sumArr = new int[leftArr.length + rightArr.length];

        //for every element in both smaller arrays take smallest and put it into temporary array
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] <= rightArr[r]) {
                sumArr[s] = leftArr[l];
                l++;
            } else {
                sumArr[s] = rightArr[r];
                r++;
            }
            s++;
        }

        //append remaining elements if arrays were of different lengths
        while (l < leftArr.length) {
            sumArr[s] = leftArr[l]; //case with larger left array
            l++;
            s++;
        }
        while (r < rightArr.length) {
            sumArr[s] = rightArr[r]; //case with larger right array
            r++;
            s++;
        }

        //reinitializing initial array
        for (int i = 0; i < sumArr.length; i++) {
            arr[i] = sumArr[i];
        }
        return arr;
    }
}
