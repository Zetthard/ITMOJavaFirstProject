package zetthard.lesson4;

import org.w3c.dom.TypeInfo;

import java.lang.invoke.TypeDescriptor;

public class Lesson4 {
    public static void main(String[] args) {

        //4.1 test
        /*String[] fewStrings = { "Hi", "Hello", "Good Morning" };
        System.out.println(getLongest(fewStrings));*/

        //4.2 test
        /*String pal1 = "Home";
        String pal2 = "House";
        String pal3 = "hahah";
        String pal4 = "la-aa-al";
        String pal5 = "mirror";
        System.out.println(pal1);
        System.out.println(isPalindrome(pal1));
        System.out.println(pal2);
        System.out.println(isPalindrome(pal2));
        System.out.println(pal3);
        System.out.println(isPalindrome(pal3));
        System.out.println(pal4);
        System.out.println(isPalindrome(pal4));
        System.out.println(pal5);
        System.out.println(isPalindrome(pal5));*/

        //4.3 test
        /*String toCensor = "PHP lived, PHP lives, long live PHP!";
        System.out.println(strReplace(toCensor));*/

        //4.4 test
        /*String str1 = "mumu";
        String str2 = "ho-hhho-ho";
        System.out.println(countSubstrOccur(str1, "mu"));
        System.out.println(countSubstrOccur(str2, "ho"));
        System.out.println(countSubstrOccur(str2, "ha"));*/

        //4.5 test
        /*String str3 = "sample text for test";
        System.out.println(mirrorWords(str3));*/
    }

    //4.1 finds the longest string withing the given array of strings
    public static String getLongest(String[] strings) {
        String longest = "";

        //check length of every string in array and if it's length is larger than temporary, reassign temporary var
        for (String string : strings) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        return longest;
    }

    //4.2 check if palindrome
    public static boolean isPalindrome (String str) {

        //spit input string tp char Array
        char[] symbs = str.toCharArray();
        boolean ans = false;
        //check if first char equals last till the middle is reached
        for (int i = 0, j = symbs.length - 1; i < symbs.length / 2; i++, j--) {
            if (symbs[i] != symbs[j]) {
                ans = false;
                break;
            } else { ans = true; }
        }
        return ans;
    }

    //4.3 replace string fragment
    public static String strReplace (String str) {

        return str.replaceAll("PHP", "[вырезано цензурой]");
    }

    //4.4 count occurrences of substring in string
    public static int countSubstrOccur (String target, String sub) {

        //initialize helper variables
        int nextInd = 0;
        int counter = 0;

        //check if remaining substring contains desired sub. If so, count it and move starting index
        while (target.length() >= sub.length() + nextInd) {
            String tail = target.substring(nextInd);
            if (tail.contains(sub)) {
                counter++;
                int slide = tail.indexOf(sub);
                nextInd += sub.length() + slide;
            } else { break; }
        }
        return counter;
    }

    //4.5 mirror every word in a string
    public static String mirrorWords (String str) {

        //split input string into words
        String[] words = str.split(" ");
        //initialize sb
        StringBuilder res = new StringBuilder();

        //reverse every word and append to resulting string
        for (var word :
                words) {
            StringBuilder mirror = new StringBuilder(word);
            mirror.reverse();
            res.append(mirror).append(" ");
        }
        return res.toString();
    }
}
