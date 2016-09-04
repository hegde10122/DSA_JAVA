package info.hegdeganesh.binarytree;

import info.hegdeganesh.commonutils.Position;

/**
 * Created by Hegade on 06-12-2015.
 *
 */
public interface BTPosition extends Position {

public void setElement(Object o);
public void setLeft(BTPosition v);
public void setRight(BTPosition v);
public void setParent(BTPosition v);

public BTPosition getLeft();
public BTPosition getRight();
public BTPosition getParent();

}//interface ends
