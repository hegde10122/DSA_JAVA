package info.hegdeganesh.lists;

import info.hegdeganesh.commonutils.BoundaryViolationException;
import info.hegdeganesh.commonutils.InvalidPositionException;
import info.hegdeganesh.commonutils.Position;

/**
 * Created by Hegade on 06-12-2015.
 */
public interface List {

    //returns the number of elements in the list
    public int size();

    //returns whether the list is empty
    public boolean isEmpty();

    //returns first node in the list
    public Position first();

    //returns last node in the list
    public Position last();

    //returns the node after a given node in the list
    public Position next(Position p)
        throws InvalidPositionException, BoundaryViolationException;

    //returns the node before a given node in the list
    public Position prev(Position p)
            throws InvalidPositionException, BoundaryViolationException;

    //inserts an element at the front of the list
    public Position insertFirst(Object e);

    //inserts an element at the back of the list
    public Position insertLast(Object e);

    //inserts an element after a given node in the list
    public Position insertAfter(Position p,Object e)
        throws InvalidPositionException;

    //inserts an element before a given node in the list
    public Position insertBefore(Position p,Object e)
            throws InvalidPositionException;

    //removes a node from the list
    public Object remove(Position p) throws InvalidPositionException;

    //replaces the element stored at the given node
    public Object replace(Position p,Object e) throws  InvalidPositionException;

}
//list interface ends