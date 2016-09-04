package info.hegdeganesh.binarytree;

/**
 * Created by Hegade on 06-12-2015.
 */
public class BTNode implements BTPosition {

    private Object element; //element stored at this node
    private BTPosition left,right,parent; //adjacent nodes

    public BTNode(Object element,BTPosition left,BTPosition right,BTPosition parent){
        setElement(element);
        setLeft(left);
        setRight(right);
        setParent(parent);
    }

    @Override
    public void setElement(Object o) {
            element = o;
    }

    @Override
    public void setLeft(BTPosition v) {
            left = v;
    }

    @Override
    public void setRight(BTPosition v) {
            right = v;
    }

    @Override
    public void setParent(BTPosition v) {
            parent = v;
    }

    @Override
    public BTPosition getLeft() {
        return left;
    }

    @Override
    public BTPosition getRight() {
        return right;
    }

    @Override
    public BTPosition getParent() {
        return parent;
    }

    @Override
    public Object element() {
        return element;
    }
}
