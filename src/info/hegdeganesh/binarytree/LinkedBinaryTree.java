package info.hegdeganesh.binarytree;

import info.hegdeganesh.commonutils.BoundaryViolationException;
import info.hegdeganesh.commonutils.EmptyTreeException;
import info.hegdeganesh.commonutils.InvalidPositionException;
import info.hegdeganesh.commonutils.Position;

import java.util.Iterator;

/**
 * Created by Hegade on 06-12-2015.
 */
public class LinkedBinaryTree implements BinaryTree {

    protected Position root; //reference to the root
    protected Position currentNode;
    protected int size;//number of nodes

    public LinkedBinaryTree(){
        root = null; //start with an empty tree
        size = 0;
    }

//----------------------------------------------------------------------------------------------------------------------
   public  void insert(Object element){

       if(isEmpty()){
           root = createNode(element,null,null,null); //create root node
           size = 1;
           currentNode = root;
       }
        else{
           currentNode =  insertNode(root,element);
       }




          /*      if(isEmpty()){
                    root = createNode(element,null,null,null); //create root node
                    size = 1;
                    currentNode = root;
                }
                else{
                        if(!hasLeft(currentNode)){
                            BTPosition vv = (BTPosition)currentNode;
                            BTPosition ww = createNode(element,vv,null,null);
                            ((BTPosition)currentNode).setLeft(ww);
                            size++;
                            return;
                        }
                    else if(!hasRight(currentNode)){
                            BTPosition vv = (BTPosition)currentNode;
                            BTPosition ww = createNode(element,vv,null,null);
                            ((BTPosition)currentNode).setRight(ww);
                            size++;
                            currentNode = ((BTPosition) currentNode).getLeft();
                            return;
                        }
                }*/


       /* Function to insert data recursively */
      /* private BTNode insert(BTNode node, int data)
       {
           if (node == null)
               node = new BTNode(data);
           else
           {
               if (node.getRight() == null)
                   node.right = insert(node.right, data);
               else
                   node.left = insert(node.left, data);
           }
           return node;
       }*/
   }//insert ends

    private Position insertNode(Position node,Object element){

            if(!hasLeft(node)){
                BTPosition vv = (BTPosition)node;
                BTPosition ww = createNode(element,vv,null,null);
                ((BTPosition)node).setLeft(ww);
                size++;

            }



        return currentNode;
    }

//----------------------------------------------------------------------------------------------------------------------
    //creates a new binary tree node
    protected BTPosition createNode(Object element,BTPosition parent,BTPosition left,BTPosition right){
        return new BTNode(element,left,right,parent);
    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    //returns the left child of a node
    public Position left(Position v) throws InvalidPositionException, BoundaryViolationException {

        if(!hasLeft(v))
            throw new BoundaryViolationException("No left child");
        return ((BTPosition)v).getLeft();
    }

    @Override
    //returns the right child of a node
    public Position right(Position v) throws InvalidPositionException, BoundaryViolationException {
        if(!hasRight(v))
            throw new BoundaryViolationException("No right child");
        return ((BTPosition)v).getRight();

    }

    @Override
    //returns whether the node has a left child
    public boolean hasLeft(Position v) throws InvalidPositionException {

        BTPosition vv = checkPosition(v);

        return (vv.getLeft()!=null);
    }

    @Override
    //returns whether the node has a right child
    public boolean hasRight(Position v) throws InvalidPositionException {
        BTPosition vv = checkPosition(v);

        return (vv.getRight()!=null);
    }

    @Override
    //returns the number of nodes in the tree
    public int size() {
        return size;
    }

    @Override
    //returns whether the tree is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Iterator elements() {
        return null;
    }

    @Override
    public Iterator positions() {
        return null;
    }

    @Override
    public Object replace(Position v, Object e) throws InvalidPositionException {
        return null;
    }

    @Override
    //returns the root of the tree
    public Position root() throws EmptyTreeException {
        if(root == null)
            throw new EmptyTreeException("The tree has no root");

        return  root;
    }

    @Override
    public Position parent(Position v) throws InvalidPositionException, BoundaryViolationException {
        return null;
    }

    @Override
    public Iterator children(Position v) throws InvalidPositionException {
        return null;
    }

    @Override
    //returns whether the node is internal
    public boolean isInternal(Position v) throws InvalidPositionException {
        checkPosition(v);
        return (hasLeft(v) || hasRight(v));
    }

    @Override
    //returns whether the node is external
    public boolean isExternal(Position v) throws InvalidPositionException {
        return !isInternal(v);
    }

    @Override
    //returns whether the node is the root
    public boolean isRoot(Position v) throws InvalidPositionException {
        checkPosition(v);
        return (v == root());
    }


    //if v is a good binary tree node, cast to BTPosition else throw exception
    private BTPosition checkPosition(Position v) throws InvalidPositionException{

        if(v == null || !(v instanceof BTPosition))
            throw new InvalidPositionException("The position is invalid");
        return (BTPosition) v;
    }



}//class LinkedBinaryTree ends
