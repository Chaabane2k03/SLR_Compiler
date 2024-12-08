/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compilerigl3.Token;
import exception.LexicalException;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 *
 * @author MSI
 */

@Getter
public class TokenReader {
    
    private final String input;
    private int position;
    
    
    private static final Map<String, TokenType> keywords = new HashMap<>();

    static {
        keywords.put("debut", TokenType.DEBUT);
        keywords.put("fin", TokenType.FIN);
        keywords.put("entier", TokenType.ENTIER);
        keywords.put("réel", TokenType.REEL);
        keywords.put("chaine", TokenType.CHAINE);
        keywords.put("lire", TokenType.LIRE);
        keywords.put("afficher", TokenType.AFFICHER);
        keywords.put("si", TokenType.SI);
        keywords.put("alors", TokenType.ALORS);
        keywords.put("sinon", TokenType.SINON);
        keywords.put("finsi", TokenType.FINSI);
        keywords.put("tantque", TokenType.TANTQUE);
        keywords.put("faire", TokenType.FAIRE);
        keywords.put("fintq", TokenType.FINTQ);
        keywords.put("Vrai", TokenType.VRAI);
        keywords.put("Faux", TokenType.FAUX);
    }
    
    public TokenReader(String input) {
        this.input = input;
        this.position = 0;
    }
    
     public int getPosition() {
        return position;
    }
    
    public Token readIdentifier(int start , int rowNumber){
        position = start;
        while (position < input.length() && (Character.isLetterOrDigit(input.charAt(position)))) {
            position++;
        }
        String value = input.substring(start, position);
        TokenType type = keywords.getOrDefault(value, TokenType.ID);
        return new Token(type, value, rowNumber);
    }
    
    
    public Token readOperator(int start, int rowNumber) {
        char currentChar = input.charAt(start);

        // Handle assignment operator <- specifically
        if (currentChar == '<' && start + 1 < input.length() && input.charAt(start + 1) == '-') {
            position = start + 2;
            return new Token(TokenType.ASSIGN, "<-", rowNumber);
        }

        // Single-character operators
        position = start + 1;
        switch (currentChar) {
            case '+' -> {
                return new Token(TokenType.PLUS, "+", rowNumber);
            }
            case '-' -> {
                return new Token(TokenType.MOINS, "-", rowNumber);
            }
            case '*' -> {
                return new Token(TokenType.MULT, "*", rowNumber);
            }
            case '/' -> {
                return new Token(TokenType.DIV, "/", rowNumber);
            }
            case '<' -> {
                return new Token(TokenType.INF, "<", rowNumber);
            }
            case '>' -> {
                return new Token(TokenType.SUP, ">", rowNumber);
            }
            case '=' -> {
                return new Token(TokenType.EGAL, "=", rowNumber);
            }
            default -> throw new LexicalException("Erreur lexicale : opérateur inconnu '" + currentChar + "'");
        }
    }
    
    public Token readPunctuation(int start, int rowNumber) {
        char currentChar = input.charAt(start);
        position = start + 1;
        switch (currentChar) {
            case ';' -> {
                return new Token(TokenType.POINT_VIRGULE, ";", rowNumber);
            }
            case '(' -> {
                return new Token(TokenType.PARENTHESE_OUVRANTE, "(", rowNumber);
            }
            case ')' -> {
                return new Token(TokenType.PARENTHESE_FERMANTE, ")", rowNumber);
            }
            default -> throw new LexicalException("Erreur lexicale (ligne : " + rowNumber + " ) : symbole de ponctuation inconnu '" + currentChar + "'");
        }
    }

    public static boolean isOperator(char c) {
        return "+-*/<>=&|".indexOf(c) != -1;
    }

    public static boolean isPunctuation(char c) {
        return ";()".indexOf(c) != -1;
    }
    
    
    
}
