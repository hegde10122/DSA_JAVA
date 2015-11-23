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
}//class ends
