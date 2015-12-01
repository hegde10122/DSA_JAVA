package info.hegdeganesh.stacks;

import java.util.Objects;

/**
 * Created by Hegade on 01-12-2015.
 */
public class Node {
    private Object element;
    private Node next;
//----------------------------------------------------------------------------------------------------------------------
    /*Creates a node with null references to its element and next node*/
    public Node(){
        this(null,null);
    }

    public Node(Object e,Node n){
        element = e;
        next = n;
    }
//----------------------------------------------------------------------------------------------------------------------
    //Accessor methods
    public Object getElement(){
        return element;
    }

    public Node getNext(){
        return next;
    }
//----------------------------------------------------------------------------------------------------------------------
    //modifier methods
    public void setElement(Object newElement){
        element = newElement;
    }

    public void setNext(Node newNext){
        next = newNext;
    }
//----------------------------------------------------------------------------------------------------------------------
}//class ends
