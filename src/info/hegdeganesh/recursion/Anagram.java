package info.hegdeganesh.recursion;

import info.hegdeganesh.commonutils.CommonUtils;

/**
 * Created by Hegade on 20-11-2015.
 *
 * The original code has been written by Robert Lafore and the entire credit goes to his
 * hardwork. I have just reproduced it for convenience.
 *
 *  */
public class Anagram {

    private static int size = 0;
    private static int count = 0;
    private static char[] arrChar;

    public static  void main(String[] args){

        System.out.print("Enter a word: "); //get the word
        String input = new CommonUtils().getString();
        size = input.length(); //size of the input

        if(size == 0){
            System.out.print("Please enter something");
            return;
        }

        arrChar = new char[size];

        for(int i=0;i<size;i++)
            arrChar[i] = input.charAt(i);

        //call the method
        anagram(size);

    }//main ends

    private static void anagram(int size1){

        if(size1 == 1)return; //no anagramming required.

            for(int i=0;i<size1;i++){
                anagram(size1 - 1); //reduce by one and anagram again -- recursive call

                if(size1 == 2)displayWord(); //innermost
                rotate(size1);
            }//for loop ends
        }//anagram method ends

        private static void displayWord(){
            System.out.print(++count + " --> ");

            for(int i=0;i<size;i++){
                System.out.print(arrChar[i]);
            }
            System.out.flush();
            System.out.println();
        }//displayWord ends


    private static void rotate(int size2){
        int j = 0;

        int position = size - size2;
        char temp = arrChar[position];

        for(j=position+1; j<size; j++){//shift others to the left
            arrChar[j-1] = arrChar[j];
        }
        arrChar[j-1] = temp;
    }

}//class ends
