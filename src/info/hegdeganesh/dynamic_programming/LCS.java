package info.hegdeganesh.dynamic_programming;

import java.util.Scanner;

/**
 * Created by GR Hegde on 05-09-2016.
 *
 * In the LCWproblem we look for the longest common subword.
 * Here we check the longest common sequence by allowing dropping some letters (subsequence)
 *
 * Given two strings, find the length of the longest common subsequence
 * secret,secretary --- "secret" length 6
 * bisect,trisect --- isect,length r
 * bisect,secret --- sect,length 4. In "secret" after "sec" we are allowed to drop letters r and e until we find t that is present in bisect
 * directory,secretary --- "ectr", "retr" length 4
 *
 * Let u = a(0)a(1)a(2)....a(m-1)am and v = b(0)b(1)b(2)....b(n-1)b(n) be two strings
 *
 *
 */
public class LCS {//longest common subsequence

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

    System.out.println("Length of the longest common subword or substring is : "+lcs(string1,string2));

}//main() ends

    private static int lcs(String str1,String str2){

        int len  = 0;/// value is 0 initially for the length of lcs
        String subSequence = "";

        //string lengths
        int m = str1.length();
        int n = str2.length();

        //construct a 2-D matrix whose rows and cols exceed the length of both the strings by 1 each
        int[][] lcsMatrix = new int[m + 1][n + 1];

        //variables r --- row goes from top to bottom and c --- column goes from left to right (0 to n - 1)
        for(int c = n - 1; c >= 0 ;c--) { //we start backwards col-col comparison
            for (int r = m - 1; r >= 0; r--) {
                if (str1.charAt(r) == str2.charAt(c)) {
                    lcsMatrix[r][c] = 1 + lcsMatrix[r + 1][c + 1];//dynamic programming --- inductive structure
                   // subSequence += str1.charAt(r);
                    //System.out.println(subSequence + " r = "+r+" c = "+c);
                    //break;
                } else
                {
                    lcsMatrix[r][c] =  Math.max(lcsMatrix[r + 1][c], lcsMatrix[r][c + 1]);
                }
            }
        }

       /* if(lcsMatrix[0][0]!=0)// print the LCS from the substring of the first string
            System.out.println("The longest common subsequence is : "+subSequence);
*/
        return lcsMatrix[0][0];
    }

}//class ends
