package info.hegdeganesh.recursion;


/**
 * Created by Hegade on 25-11-2015.
 */
public class MergeSort {

    private static final int MAX_SIZE = 16;
    private static ArrayInsert aIns;

    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){

        aIns = new ArrayInsert(MAX_SIZE);


        for (int i = 0; i < MAX_SIZE; i++) {
            long n1 = (int) Math.round(Math.random() * 100);
            aIns.insert(n1);
        }

        aIns.display();
        aIns.mergeSort();
        aIns.display();

    }//main ends

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class ArrayInsert {

        private long theArray[];// array
        private int numElements; //number of items

        //--------------------------------------------------------------------------------------------
        public ArrayInsert(int maximum) {//constructor
            theArray = new long[maximum];
            numElements = 0;
        }

        //--------------------------------------------------------------------------------------------
        public void insert(long value) { //put elements into array
            theArray[numElements++] = value; //insert and then increment
        }

        //--------------------------------------------------------------------------------------------
        public void display() {//display array contents

            System.out.print("Array = ");
            for (int y = 0; y < numElements; y++) {
                System.out.print("\t" + theArray[y]);
            }
            System.out.println();
        }

        //------------------------------------------------------------------------------------------------------------------
        private void mergeSort(){
            long[] workSpace = new long[numElements];
            recMergeSort(workSpace,0,numElements - 1);
        }
        //--------------------------------------------------------------------------------------------
        private  void merge(long[] workSpace,int lowPtr,int highPtr,int upperBound){

            int j = 0; //workspace index
            int lowerBound = lowPtr;
            int mid = highPtr - 1;
            int n = upperBound - lowerBound + 1; // number of items

            while(lowPtr<= mid && highPtr <= upperBound)
               if(theArray[lowPtr] < theArray[highPtr])
                   workSpace[j++] = theArray[lowPtr++];
               else
                   workSpace[j++] = theArray[highPtr++];

            while(lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while(highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for(j=0;j<n;j++)
                theArray[lowerBound+j] = workSpace[j];
        }//end merge
        //------------------------------------------------------------------------------------------------------------------
        private void recMergeSort(long[] workSpace,int lowerBound,int upperBound){

            if(lowerBound == upperBound)return;//if range is 1,no use sorting
            else {
                int mid = (lowerBound + upperBound) / 2;//find midpoint
                recMergeSort(workSpace, lowerBound, mid);//sort lower half
                recMergeSort(workSpace, mid + 1, upperBound);//sort upper half
                merge(workSpace, lowerBound, mid + 1, upperBound);
            }
        //------------------------------------------------------------------------------------------------------------------
        }//end recMergeSort
    }//class ends
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}//class ends
