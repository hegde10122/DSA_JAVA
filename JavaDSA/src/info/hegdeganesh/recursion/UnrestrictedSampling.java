package info.hegdeganesh.recursion;

import info.hegdeganesh.commonutils.CommonUtils;

/**
 * Created by Hegade on 22-11-2015.
 */
public class UnrestrictedSampling {

    //size of the word entered
    private static int size = 0;

    private static char[] arrChar;
    private static int[] column;

    //count the permutations and display for convenience
    private static int permutation = 1;

    public static void main(String[] args){

        System.out.print("Enter a word or string of characters: "); //get the word
        String input = new CommonUtils().getString();

        size = input.length(); //size of the input

        if(size == 0){
            System.out.print("Please enter something");
            return;
        }

        arrChar = new char[size];
        column = new int[size];

        for(int i=0;i<size;i++){
            arrChar[i] = input.charAt(i);
            column[i] = -1;
        }
        sample(0);
    }//main ends

    private static void sample(int k){
        column[k] = 0;

        while(column[k] < size){
            column[k] = column[k] + 1;

            if(k < size - 1)
                sample(k+1);
            else{
                   int j = 0;
                System.out.print(permutation+ " --> ");
                   while(j < size){
                       System.out.print("\t"+column[j]);
                       j++;
                   }
                permutation++; System.out.println();
            }
        }
    }

}//class ends
