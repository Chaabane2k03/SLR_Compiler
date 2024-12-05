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

        String code = scanner.toString();
        LexicalParser lexer = new LexicalParser(code);        
        
        
        List<Token> tokens = lexer.parse();
                
        System.out.println("*********************ANALYSE LEXICALE************************");

        for (Token token : tokens) {
            System.out.println(token);
        }
        
        System.out.println("*********************ANALYSE SYNTAXIQUE****************");

        Parsernew parser = new Parsernew();
        parser.analyzeSLnew(tokens);


        
    }
}
