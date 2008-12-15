package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input
{
    public static String readText(String prompt)
    {
        String str = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (str == null)
        {
            System.out.println(prompt);
            try
            {
                str = reader.readLine();
            } catch (IOException e)
            {
                System.err.println("Fehler: " + e.getMessage());
                str = null;
            }
        }
        return str;
    }
    
    
    
    public static int readInt(String prompt)
    {
        int i = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                i = Integer.parseInt(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Ganzzahl eingeben");
            }
        }
        
        return i;
    }
    
    
    public static double readDouble(String prompt)
    {
        double i = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                i = Double.parseDouble(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bitte Ganzzahl eingeben");
            }
        }
        
        return i;
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(Input.readText("readText"));
    }
}
