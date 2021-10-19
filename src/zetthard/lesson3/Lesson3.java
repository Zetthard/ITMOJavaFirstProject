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

        System.out.println(isSorted(array1));
        System.out.println(isSorted(array2));
        System.out.println(isSorted(array3));
        System.out.println(isSorted(array4));
        System.out.println(isSorted(array5));
        System.out.println(isSorted(array6));*/

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
        System.out.println("Array to sort #1: ");
        System.out.println(Arrays.toString(arrayToSort));
        int[] sortedArray = myMergeSort(arrayToSort);
        System.out.println("Result: ");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println();
        System.out.println("Array to sort #1: ");
        System.out.println(Arrays.toString(arrayToSort2));
        int[] sortedArray2 = myMergeSort(arrayToSort2);
        System.out.println("Result: ");
        System.out.println(Arrays.toString(sortedArray2));*/

        //3.7 test
        /*int[] freqArray = { 1, 2, 3, 4, 1, 5, 3, 4, 1, 5, 1, 5, 3 };
        int[] freqArray2 = { 0, 2, 3, 4, 1, 5, 3, 4, 7, 5, 1, 5, 3 };
        System.out.println("Most frequent elements: " + Arrays.toString(getMostFrequent(freqArray, 2)));
        System.out.println();
        System.out.println("Most frequent elements: " + Arrays.toString(getMostFrequent(freqArray2, 2)));*/

    }

    //3.1
    public static String isSorted (int[] ints){

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

            //skip element if already checked same value
            for (var num :
                    checked) {
                if (num == arr[i]) {
                    continue;
                } else {
                    checked[i] = arr[i]; //otherwise, add value to the collection
                }
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

        //split original array in two and initialize both by copying original elements manually
        int lSize = arr.length / 2;
        int rSize = arr.length - lSize;
        int[] leftArr = new int[lSize];
        int[] rightArr = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = 0; i < rSize; i++) {
            rightArr[i] = arr[lSize + i];
        }

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

    //3.7
    public static int[] getMostFrequent (int[] arr, int k) {

        //variable to store results
        int[] res = new int[k];

        //variable to store number of occurrences
        int[] counts = new int[arr.length];

        //collection of already checked values
        int[] checked = new int[arr.length];

        //take every element of the array
        for (int j = 0; j < arr.length; j++) {

            //iterate through checked values collection
            for (int i = 0; i < checked.length; i++) {

                //if not in collection and this is last iteration, means this value is not checked
                if (checked[i] != arr[j] && i == checked.length - 1) {

                    checked[j] = arr[j]; //add value to collection and

                    //compare it to other elements in a given array and count matches
                    int count = 0;
                    for (int m = 0; m < arr.length; m++) {

                        if (m != j && arr[m] == arr[j]) {
                            count++;
                        }
                    }
                    counts[j] = count; //write matches count to array
                } else if (checked[i] == arr[j]) {
                    break; //if already checked skip it
                }
            }
        }

        //print input array, and it's elements counts for user reference only
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Element counts: " + Arrays.toString(counts));

        //now find maximum of 'counts' array elements. And do it k times
        int n = 0;
        for (int i = 0; i < k; i++) {
            int max = 0;
            for (int j = n; j < counts.length; j++) {
                if (counts[j] > max) {
                    max = counts[j];
                    res[i] = arr[j];
                    n += j + 1;
                }
            }
        }
        return res;
    }
}
