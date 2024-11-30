package com.mycompany.compilerigl3;

import com.mycompany.compilerigl3.Token.Token;
import java.util.List;

/**
 *
 * @author MSI
 */
public class CompilerIGL3 {

    public static void main(String[] args) {
        String code = "entier x "
                + "debut "
                + "lire x ;  "
                + "afficher (x) ;"
                + "fin";
        LexicalParser lexer = new LexicalParser(code);
        List<Token> tokens = lexer.parse();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
