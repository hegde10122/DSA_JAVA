package info.hegdeganesh.commonutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Hegade on 20-11-2015.
 */
public class CommonUtils {

    public static String getString(){

        InputStreamReader is = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(is);
        String string = null;
        try {
            string = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
       return string;
    }

    //-------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
}//class ends
