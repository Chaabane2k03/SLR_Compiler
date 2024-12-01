
package com.mycompany.compilerigl3;

import com.mycompany.compilerigl3.Token.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MSI
 */
public class LexicalParser {
    
    private final String input;
    private int position;
    private int rowNumber;
    private final TokenReader tokenReader;

    
   
    
    public LexicalParser(String input){
        this.input = input;
        this.position = 0;
        this.rowNumber = 1;
        this.tokenReader = new TokenReader(input);
    }
    
    
    
    public List<Token> parse(){
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            switch (currentChar){
                case ' ', '\t', '\r', '\n' -> {
                    // Handle whitespace and newlines
                    if (currentChar == '\n') rowNumber++;
                    position++;
                }
                default -> {
                    if (Character.isLetter(currentChar)) {
                        Token token = tokenReader.readIdentifier(position, rowNumber);
                        position = tokenReader.getPosition();
                        tokens.add(token);
                    }
                    else if (TokenReader.isOperator(currentChar)) {
                        Token token = tokenReader.readOperator(position, rowNumber);
                        position = tokenReader.getPosition();
                        tokens.add(token);
                    } else if (TokenReader.isPunctuation(currentChar)) {
                        Token token = tokenReader.readPunctuation(position, rowNumber);
                        position = tokenReader.getPosition();
                        tokens.add(token);
                    } else {
                        throw new RuntimeException("Erreur lexicale à la ligne " + rowNumber + " : caractère inconnu '" + currentChar + "'");
                    }
                }
            }
        }
        tokens.add(new Token(TokenType.EOF,"$",rowNumber));
        return tokens;
    }
    
    
    
}
