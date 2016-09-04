package info.hegdeganesh.recursion;

/**
 * Created by Ganesh Hegde on 24-11-2015.
 */
public class RecursiveQuickSort {

private static final int MAX_SIZE = 16;
private static ArrayInsert aIns;

public static void main(String[] args){

    aIns = new ArrayInsert(MAX_SIZE);

    for(int i=0;i<MAX_SIZE;i++){
        long n1 = (int)Math.round(Math.random()*100);
        aIns.insert(n1);
    }

    aIns.display();
    aIns.quickSort();
    aIns.display();

}//main ends

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
static class ArrayInsert{

    private long theArray[];// array
    private int numElements; //number of items

   //--------------------------------------------------------------------------------------------
   public ArrayInsert(int maximum){//constructor
        theArray = new long[maximum];
        numElements = 0;
   }
   //--------------------------------------------------------------------------------------------
    public void insert(long value){ //put elements into array
        theArray[numElements++] = value; //insert and then increment
    }
    //--------------------------------------------------------------------------------------------
    public void display(){//display array contents

        System.out.print("Array = ");
        for(int y=0;y<numElements;y++){
            System.out.print("\t"+theArray[y]);
        }
        System.out.println();
    }
    //--------------------------------------------------------------------------------------------
    public void quickSort(){
        recQuickSort(0,numElements - 1);
    }
    //--------------------------------------------------------------------------------------------
    private void recQuickSort(int left,int right){

        if(right - left <=0) //if size is <= 1
            return;
        else{ //size is 2 or larger

            long pivot = theArray[right];//rightmost item

            //partition range
            int partition = partitionIt(left,right,pivot);

            recQuickSort(left,partition-1);//sort left side
            recQuickSort(partition+1,right);//sort right side
        }
    }
    //--------------------------------------------------------------------------------------------
    private int partitionIt(int left,int right, long pivot){

        int leftPtr = left - 1; // after increment  --> left
        int rightPtr = right; // after decrement  --> right

        while(true){

            //find bigger item
            while(theArray[++leftPtr] < pivot );//nop

            //find smaller item
            while(rightPtr > 0 && theArray[--rightPtr] > pivot );//nop

            if(leftPtr >= rightPtr)//if pointers cross
                break; //partition done
            else //not crossed,so
                swap(leftPtr,rightPtr); //swap elements
        }//end while(true)

        swap(leftPtr,right); //restore pivot
        return leftPtr; //restore pivot location
    }
    //--------------------------------------------------------------------------------------------
    private void swap(int d1,int d2){//swap two elements
        long temp = theArray[d1];
        theArray[d1] = theArray[d2];
        theArray[d2] = temp;
    }
    //--------------------------------------------------------------------------------------------
}//class ends
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}//class ends


