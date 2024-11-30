package com.mycompany.compilerigl3.Token;

public class Token {
    private final TokenType type;
    private final String value;
    private final Integer rowNumber;

    // Constructor (All arguments)
    public Token(TokenType type, String value, Integer rowNumber) {
        this.type = type;
        this.value = value;
        this.rowNumber = rowNumber;
    }

    // Getters
    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                ", rowNumber=" + rowNumber +
                '}';
    }
}
