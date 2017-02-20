/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author moroclash
 */
public class Excute {
      public ArrayList<String> Fun(String Que) {
        ArrayList<String> S = new ArrayList<>(10);
        String s = null;
        try {
            Process p = Runtime.getRuntime().exec(Que);
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            if (p.getInputStream() != null) {
                while ((s = stdInput.readLine()) != null) {
                    S.add(s);
                }
            } else {
                while ((s = stdError.readLine()) != null) {
                    S.add(s);
                }
            }
                    
        } catch (Exception E) {
            E.printStackTrace();
        }
        return S;
    }
      
      public static void main(String[] args) {
        File f = new File("moro.txt");
        f.setReadable(true, true);
        f.setWritable(true, false);
        f.setExecutable(true, false);
    }
}
