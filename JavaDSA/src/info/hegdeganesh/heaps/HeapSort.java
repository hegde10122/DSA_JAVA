package info.hegdeganesh.heaps;

/**
 * Created by Hegade on 29-11-2015.
 */
public class HeapSort {

private static final  int MAX_SIZE = 16;


    public static void main(String[] args){

        int j;
        Heap theHeap = new Heap(MAX_SIZE);

        for(int y=0;y<MAX_SIZE;y++)
        {
            Node newNode = new Node( (int)Math.round(Math.random()*99) );
            theHeap.insertAt(y,newNode);
            theHeap.incrementSize();
        }

        System.out.print("Random : ");
        theHeap.displayArray();

        for(j=MAX_SIZE/2-1;j>=0;j--)//make random array into heap
            theHeap.trickleDown(j);

        System.out.print("Heap: ");
        theHeap.displayArray();
        theHeap.displayHeap();

        for(j=MAX_SIZE-1; j>=0; j--)
        {
            Node biggestNode = theHeap.remove();
            theHeap.insertAt(j,biggestNode);
        }
        System.out.print("Sorted : ");
        theHeap.displayArray();
    }//end main()
}//end class Heapsort()
