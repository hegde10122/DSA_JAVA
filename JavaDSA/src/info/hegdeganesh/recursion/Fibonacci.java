package info.hegdeganesh.recursion;

import info.hegdeganesh.commonutils.CommonUtils;

/**
 * Created by Hegade on 22-11-2015.
 */
public class Fibonacci {

    private static int size = 0;
    private static int count = 0;
    private static  int n1 = 1, n2 = 1;
    private static final int MAX_SIZE = 45;

    public static void main(String[] args){

        System.out.println("Enter the total numbers in your fibonacci sequence not greater than "+MAX_SIZE+"\n");

        String input = new CommonUtils().getString();

        try{
            size  = Integer.parseInt(input);

            if(size <= 1 || size > MAX_SIZE){
                System.out.print("Please enter at least 2 count for fibonacci sequence not greater than "+MAX_SIZE+"\n");
                return;
            }
        }catch (Exception e){
            System.out.print("Please enter positive integer");
            return;
        }

            fibonacci(n1,n2);
    }//main ends

    private static void fibonacci(int n1,int n2){

        if(count > size - 2)return;

        if(count == 0){
            System.out.println("The fibonacci sequence for first "+size+" numbers is : \n");
            System.out.print("\t" + n1 + "\t" + n2);
        }

        if(count % 10 == 0 && count!=0)System.out.println();

           if(count > 0)System.out.print("\t"+n2);

            count++;
            fibonacci(n2,n2+n1);//recursive call
    }
}//class ends
