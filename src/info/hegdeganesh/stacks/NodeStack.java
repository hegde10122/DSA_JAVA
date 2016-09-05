package info.hegdeganesh.stacks;
import info.hegdeganesh.commonutils.StackEmptyException;


/**
 * Created by Hegade on 01-12-2015.
 */
public class NodeStack implements Stack {

    protected  Node top; //reference to  the head node
    protected int size; // number of elements in the stack

    public NodeStack(){//constructs empty stack
        top = null;
        size = 0;
    }

//-------OVERRIDEN METHODS FROM INTERFACE ------------------------------------------------------------------------------
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if(top == null)
            return true;
        return false;
    }

    @Override
    public Object top() throws StackEmptyException {

        if(isEmpty())
            throw new StackEmptyException("Stack is empty");

        return top.getElement();
    }

    @Override
    public void push(Object element) {
        Node v = new Node(element,top); //create and link in a new node
        top = v;
        size++;
    }

    @Override
    public Object pop() throws StackEmptyException {

        if(isEmpty())
            throw new StackEmptyException("Stack is empty");

        Object temp = top.getElement();
        top = top.getNext(); //link out the former top node
        size--;
        return temp;
    }



//----------------------------------------------------------------------------------------------------------------------
}//classe ends
