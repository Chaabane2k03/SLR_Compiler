/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compilerigl3.Token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author MSI
 */

@Getter
@RequiredArgsConstructor
public enum TokenType {
    
    //Le
    DEBUT, FIN, ID, ENTIER, REEL, CHAINE, LIRE, AFFICHER, SI, ALORS, SINON, FINSI, 
    TANTQUE, FAIRE, FINTQ, VRAI, FAUX,
    
    //Les opérations : affectations , arithmétiques et logiques
    ASSIGN, // <-
    PLUS, MOINS, MULT, DIV,
    INF, SUP, EGAL,
    ET, OU,
    
    //Les symboles
    PARENTHESE_OUVRANTE, PARENTHESE_FERMANTE, POINT_VIRGULE,
    
    //Fin de fichier
    EOF
    
}
