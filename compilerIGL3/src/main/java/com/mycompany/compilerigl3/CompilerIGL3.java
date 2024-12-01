package com.mycompany.compilerigl3;

import com.mycompany.compilerigl3.Token.Token;
import com.mycompany.compilerigl3.slr.Parsernew;
import java.util.List;

import Scanner.Scanner;
/**
 *
 * @author MSI
 */
public class CompilerIGL3 {

    public static void main(String[] args) {
       if (args.length < 1)
        {
            System.out.print("no file provided");
            return;
        }
        
        System.out.println("**"+args[0]);
        
        String file_name = args[0];
        Scanner scanner = new Scanner(file_name);
        //Scanner scanner = new Scanner("D:\\abdo\\code\\java project\\compiler\\comp\\code.txt");

        String code = scanner.toString();
        LexicalParser lexer = new LexicalParser(code);
        List<Token> tokens = lexer.parse();
        /*
        for (Token token : tokens) {
            System.out.println(token);
        }*/
        
        Parsernew parser = new Parsernew();
        parser.analyzeSLnew(tokens);


        
    }
}
