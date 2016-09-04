package info.hegdeganesh.binarytree;

import info.hegdeganesh.commonutils.BoundaryViolationException;
import info.hegdeganesh.commonutils.InvalidPositionException;
import info.hegdeganesh.commonutils.Position;

/**
 * Created by Hegade on 03-12-2015.
 */
public interface BinaryTree extends Tree {

    //returns left child of a node
    public Position left(Position v)throws InvalidPositionException,BoundaryViolationException;

    //returns right child of a node
    public Position right(Position v)throws InvalidPositionException,BoundaryViolationException;

    //returns whether a node has a left child
    public boolean hasLeft(Position v) throws InvalidPositionException;

    //returns whether a node has a right child
    public boolean hasRight(Position v) throws InvalidPositionException;

}//interface ends
