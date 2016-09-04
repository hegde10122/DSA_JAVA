package info.hegdeganesh.binarytree;

import info.hegdeganesh.commonutils.BoundaryViolationException;
import info.hegdeganesh.commonutils.EmptyTreeException;
import info.hegdeganesh.commonutils.InvalidPositionException;
import info.hegdeganesh.commonutils.Position;

import java.util.Iterator;

/**
 * Created by Ganesh Hegde on 03-12-2015.
 *
 *An interface for a tree where nodes can have an
 arbitrary number of children
 */


public interface Tree {

    //returns the number of nodes in the tree
    public int size();

    //returns whether the tree is empty
    public boolean isEmpty();

    //returns an iterator of the elements stored in the tree
    public Iterator elements();

    //returns an iterator of the nodes stored in the tree
    public Iterator positions();

    //replaces the element stored at a given node
    public Object replace(Position v,Object e)
            throws InvalidPositionException;

    //returns the root of the tree
    public Position root() throws EmptyTreeException;

    //returns the parent of a given node
    public Position parent(Position v)
            throws InvalidPositionException,BoundaryViolationException;

    //returns an iterator of the children of a given node
    public Iterator children(Position v)
            throws InvalidPositionException;

    //returns whether a given node is internal
    public boolean isInternal(Position v)
            throws InvalidPositionException;

    //returns whether a given node is external
    public boolean isExternal(Position v)
            throws InvalidPositionException;

    //returns whether a given node is root of the tree
    public boolean isRoot(Position v)
            throws InvalidPositionException;

}//interface ends
