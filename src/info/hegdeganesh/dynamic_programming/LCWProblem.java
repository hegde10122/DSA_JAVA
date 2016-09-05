package info.hegdeganesh.dynamic_programming;

import java.util.Scanner;

/**
 * Created by GR Hegde on 05-09-2016.
 */

//Longest common subword problem

/*
* Longest common sub-word or longest common substring problem is to find the longest string (or strings)
* that is a substring (or are substrings) of two or more strings
*
* Given two strings, find the length of the longest common subword. Also print that subword
* secret, secretary  ---- secret, length 6
* bisect,trisect ---- sect, length 4
* bisect, secret ---- "sec", length 3
* director, secretary ---- "ec","re", length 2
*
* Let u and v be two strings such that u = a0a1a2....am and v = b0b1b2...bn
* If we can find i,j such that aia(i+1)....a(i+k-1) = bjb(j+1)....b(j+k-1), u and v have a common subword of length k
* Aim is to find the length of the longest subword of u and v
* */
public class LCWProblem {

public static void main(String[] args){

    System.out.println("Enter first string: ");
    Scanner sc = new Scanner(System.in);

    String string1 = sc.nextLine();

    System.out.println("Enter second string: ");
    String string2 = sc.nextLine();

    if(string1.length() == 0 || string2.length() == 0){
        System.out.println("The length of string(s) must be greater than 0");
        return;
    }

    System.out.println("Length of the longest common subword or substring is : "+lcw(string1,string2));
}

    private static int lcw(String str1,String str2){

        int len  = 0;/// value is 0 initially
        int index = Integer.MIN_VALUE;

        int m = str1.length();
        int n = str2.length();

        //construct a 2-D matrix whose rows and cols exceed the length of both the strings by 1 each
        int[][] lcwMatrix = new int[m + 1][n + 1];

        //variables r --- row goes from top to bottom and c --- column goes from left to right
        for(int c = n - 1; c >= 0 ;c--) { //we start backwards
            for (int r = m - 1; r >= 0; r--) {
                if (str1.charAt(r) == str2.charAt(c)) {
                    lcwMatrix[r][c] = 1 + lcwMatrix[r + 1][c + 1];//dynamic programming --- inductive structure
                } else
                    lcwMatrix[r][c] = 0; // reset and start afresh
                if (lcwMatrix[r][c] > len) {
                    len = lcwMatrix[r][c]; //value of the length
                    index = r; //suffix of the first string where the LCW begins
                }
            }
        }

        if(index!=Integer.MIN_VALUE)// print the LCW from the substring of the first string
        System.out.println("The longest common subword or substring is : "+str1.substring(index,index + len));

        return len;
    }

    /*
    * The dynamic programmming approach gives us O(mn). We need to fill a table of size O(mn) to achieve this.
    * Each table entry takes constant time to compute
    * */
}//class ends
