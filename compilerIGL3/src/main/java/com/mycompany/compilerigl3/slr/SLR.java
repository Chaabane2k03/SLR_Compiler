package com.mycompany.compilerigl3.slr;

public class SLR {
    public static void main(String[] args) {
        String[] tokens = {"entier", "id", ";", "debut", "id", "<-", "id", ";", "fin", "$" };

        // Instantiate the parser
        Parsernew parser = new Parsernew();

        // Output the SLR parsing table for debugging (optional)
        parser.ouput();

        // Test parsing the input
        parser.analyzeSLnew(tokens);
    }
}
