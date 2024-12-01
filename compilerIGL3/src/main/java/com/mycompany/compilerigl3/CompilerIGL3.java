package com.mycompany.compilerigl3;

import com.mycompany.compilerigl3.slr.Parsernew;
import com.mycompany.compilerigl3.Token.Token;
import Scanner.Scanner; // Your custom Scanner class
import java.util.List;

/**
 *
 * @author MSI
 */
public class CompilerIGL3 {

    public static void main(String[] args) {
        // Hardcoded file path
        String filePath = "D:\\Raed\\Desktop\\SLR_Compiler\\code.txt"; // copy it from the windows copy as path

        System.out.println("** Using file path: " + filePath);

        try {
            // Initialize your custom Scanner with the hardcoded file path
            Scanner scanner = new Scanner(filePath);
            
            // Use the toString() method to get the file content as a string
            String code = scanner.toString();
            
            // Lexical analysis
            LexicalParser lexer = new LexicalParser(code);
            List<Token> tokens = lexer.parse();

            // Parsing
            Parsernew parser = new Parsernew();
            parser.analyzeSLnew(tokens);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
