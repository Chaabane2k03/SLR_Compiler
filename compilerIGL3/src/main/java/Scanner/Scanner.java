/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Scanner {
    
     private ArrayList<Character> fluxCaracteres;
    private int indiceCourant;
    private char caractereCourant;
    private boolean eof;

    public Scanner() {
        this("");
    }

    public Scanner(String nomFich) {
        BufferedReader f=null;
        int car=0;
        fluxCaracteres=new ArrayList<Character>();
        indiceCourant=0;
        eof=false;
        try {
            f=new BufferedReader(new FileReader(nomFich));
        }
        catch(IOException e) {
            System.out.println("taper votre texte ci-dessous (ctrl+z pour finir)");
            f=new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            while((car=f.read())!=-1)
                fluxCaracteres.add((char)car);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    @Override
	public String toString() {
		// TODO Auto-generated method stub
                String s="";
                for(int i = 0;i<fluxCaracteres.size();i++)
                {
                    s+=fluxCaracteres.get(i);
                }
		return s;
	}
	
}
