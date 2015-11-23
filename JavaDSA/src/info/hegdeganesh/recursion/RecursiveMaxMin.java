package info.hegdeganesh.recursion;

/**
 * Created by Hegade on 23-11-2015.
 */
public class RecursiveMaxMin {

    private static final int MAX_SIZE = 10;
    private static int arrayValues[];

    public static  void main(String[] args){

            arrayValues = new int[MAX_SIZE];

            for(int y=0;y<MAX_SIZE;y++){
                arrayValues[y] = (int) Math.round(Math.random()*100);
                System.out.print("\t"+arrayValues[y]);
            }

      int maxValue =  findMax(arrayValues,MAX_SIZE,0);
      System.out.println("\nMaximum value is " + maxValue);

      int minValue = findMin(arrayValues,MAX_SIZE,0);
        System.out.println("\nMinimum value is " + minValue);

    }//end main

    private static int findMax(int array[],int size,int index){

        int maximum;

        if(index == size)
            return array[index - 1];

        if(size == 1){
            return array[0];
        }

        //recursive call
        maximum = findMax(array,size,index+1);

       return(array[index] > maximum) ? array[index] : maximum;
    }//findMax

    private static int findMin(int array[],int size,int index){

        int minimum;

        if(index == size)
            return array[index - 1];

        if(size == 1){
            return array[0];
        }

        //recursive call
        minimum = findMin(array,size,index+1);

        return(array[index] < minimum) ? array[index] : minimum;
    }//findMax


}//end class
