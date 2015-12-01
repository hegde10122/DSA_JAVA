package info.hegdeganesh.stacks;

/**
 * Created by Hegade on 01-12-2015.
 */
public class ReverseArray {

    private static final int MAX_SIZE = 6;

    public static void main(String[] args){

        int array[] = new int[MAX_SIZE];
        int arrayOut[] = new int[MAX_SIZE];

        NodeStack stack = new NodeStack();

        for(int y=0;y<MAX_SIZE;y++){
            array[y]=(int)Math.round(Math.random()*99);
            stack.push(array[y]);
            System.out.print("\t"+array[y]);
        }
        System.out.println();;

        for(int y=0;y<MAX_SIZE;y++){
               arrayOut[y] = (Integer) stack.pop();
            System.out.print("\t"+arrayOut[y]);
        }
  }//main ends
}//class ends
