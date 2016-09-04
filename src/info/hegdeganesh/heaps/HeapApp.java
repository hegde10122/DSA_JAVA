package info.hegdeganesh.heaps;

import info.hegdeganesh.commonutils.CommonUtils;

import java.io.IOException;

/**
 * Created by Hegade on 28-11-2015.
 */
public class HeapApp  {

private static  final int MAX_SIZE = 31;

    public static void main(String[] args) throws IOException{

        int value,value2;
        Heap theHeap = new Heap(MAX_SIZE);
        boolean success;

        for(int i=0;i<10;i++)
        theHeap.insert( (int)Math.round(Math.random()*99));

        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show,insert,remove,change: ");

            int choice = new CommonUtils().getChar();

            switch (choice){
                case 's':
                    theHeap.displayHeap();
                    break;

                case 'i':
                    System.out.print("Enter value to insert: ");

                    value = new CommonUtils().getInt();
                    success = theHeap.insert(value);
                    if(!success)
                        System.out.println("Cannot fill.Heap full");
                    break;

                case 'r':
                    if(!theHeap.isEmpty())
                        theHeap.remove();
                    else
                        System.out.println("Cannot remove.Heap empty");
                   break;

                case 'c':

                    System.out.print("Enter current value of index ");
                    value = new CommonUtils().getInt();
                    System.out.print("Enter new key: ");
                    value2 = new CommonUtils().getInt();
                    success = theHeap.change(value,value2);

                    if(!success)
                        System.out.println("Invalid index");
                    break;

                default:
                    System.out.println("Invalid entry\n");
                    break;
            }//end switch
        }//end while
    }//end main
}//end class HeapApp
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Node{
    private int iData; //data item (key)

//----------------------------------------------------------------------------------------------------------------------
public Node(int key){
    iData = key;
}
//----------------------------------------------------------------------------------------------------------------------
public int getKey(){
    return iData;
}
//----------------------------------------------------------------------------------------------------------------------
public void setKey(int id){
    iData = id;
}
//----------------------------------------------------------------------------------------------------------------------
}//end class Node
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Heap{
    private Node[] heapArray;
    private int maxSize; //size of Array
    private int currentSize; // number  of nodes in array
//----------------------------------------------------------------------------------------------------------------------
public Heap(int mx){
    maxSize = mx;
    currentSize = 0;
    heapArray = new Node[maxSize]; //create Array
}
//----------------------------------------------------------------------------------------------------------------------
public boolean isEmpty(){
    return (currentSize == 0);
}
//----------------------------------------------------------------------------------------------------------------------
public boolean insert(int key){
    if(currentSize == maxSize)return false;

    Node newNode = new Node(key);
    heapArray[currentSize] = newNode;
    trickleUp(currentSize++);
    return true;
}
//----------------------------------------------------------------------------------------------------------------------
public void trickleUp(int index){
    int parent = (index - 1)/2;
    Node bottom = heapArray[index];

    while(index > 0 && heapArray[parent].getKey()
            < bottom.getKey()){
        heapArray[index] = heapArray[parent];
        index = parent;
        parent = (parent - 1)/2;
    }//end while

    heapArray[index] = bottom;
}//end trickleUp()
//----------------------------------------------------------------------------------------------------------------------
public Node remove(){//delete item with max key

    Node root = heapArray[0];
    heapArray[0] = heapArray[--currentSize];
    trickleDown(0);
    return root;
}//end remove()
//----------------------------------------------------------------------------------------------------------------------
public void trickleDown(int index){

    int largerChild;
    Node top = heapArray[index]; //save root
    while(index < currentSize/2){ //while node has at least one child
        int leftChild = 2*index+1;
        int rightChild = leftChild+1;

        //find larger child
        if(rightChild < currentSize && //rightchild exists?
           heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
            largerChild = rightChild;
        else
            largerChild = leftChild;

        if(top.getKey() >= heapArray[largerChild].getKey())break;

        //shift child up
        heapArray[index] = heapArray[largerChild];

        index = largerChild; //go down
    }//end while

    heapArray[index] = top; //root to index
}//end trickleDown()
//----------------------------------------------------------------------------------------------------------------------

    public boolean change(int index,int newValue){

       if(index < 0 || index>= currentSize)return false;

        int oldValue = heapArray[index].getKey(); //remember old
        heapArray[index].setKey(newValue); //change to new

        if(oldValue < newValue)//if raised trickle up or if lowered trickle down
            trickleUp(index);
        else
            trickleDown(index);

    return true;
    }//end change()
//----------------------------------------------------------------------------------------------------------------------

    public void displayHeap(){

        System.out.print("heapArray :");

        for(int p=0;p<currentSize; p++)
            if(heapArray[p]!= null)
                System.out.print(heapArray[p].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; //current item
        String dots = ".........................................................";
        System.out.println(dots + dots);

        while(currentSize > 0){//for each heap item

            if(column == 0) //first item in row?
            for(int k=0;k<nBlanks;k++)//preceding blanks
            System.out.print(' ');

            //display item
            System.out.print(heapArray[j].getKey());

            if(++j == currentSize)//done?
            break;

            if(++column == itemsPerRow) //end of row?
            {
                nBlanks /=2; //half the blanks
                itemsPerRow *= 2; //twice the items
                column = 0; //start over on
                System.out.println(); // new row
            }
            else
            {
                for(int k=0;k<nBlanks*2-2; k++)
                    System.out.print(' '); //interim blanks
            }
        }//end while
        System.out.println("\n "+dots + dots);//dotted botton line
    }//end displayHeap()
//----------------------------------------------------------------------------------------------------------------------
  public void displayArray(){
      for(int j=0;j<maxSize;j++)
          System.out.print(heapArray[j].getKey()+" ");
      System.out.println();
  }
//----------------------------------------------------------------------------------------------------------------------
public void insertAt(int index,Node newNode){
    heapArray[index] = newNode;
}
//----------------------------------------------------------------------------------------------------------------------
public void incrementSize(){
    currentSize++;
}
//----------------------------------------------------------------------------------------------------------------------
}//end class Heap
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////