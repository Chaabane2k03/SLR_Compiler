package com.mycompany.compilerigl3.slr;

import com.mycompany.compilerigl3.Token.Token;
import com.mycompany.compilerigl3.Token.TokenType;


import java.util.Stack;
import java.util.List; 


public class Parsernew {

    
public String[] LRGS = {
            "P->LD debut LI fin",
            "LD->D",
            "LD->D LD",
            "D->T id ;",
            "T->entier",
            "T->reel",
            "T->BOOL",
            "T->chaine",
            "LI->I ;",
            "LI->I ; LI",
            "I->A",
            "I->L",
            "I->EC",
            "I->C",
            "I->B",
            "A->id <- EX",
            "L->lire id",
            "EC->afficher id",
            "EC->afficher ( chaine )",
            "C->si ( EX ) alors LI sinon LI finsi", 
            "C->si ( EX ) alors LI finsi",
            "B->tantque ( EX ) faire LI fintq",
            "EX->id OP id",
            "EX->id",
            "BOOL->Vrai",
            "BOOL->Faux",
            "OP->OPARTH",
            "OP->OPLOG",
            "OPARTH->+",
            "OPARTH->-",
            "OPARTH->*",
            "OPARTH->/",
            "OPLOG-><",
            "OPLOG->>",
            "OPLOG->=",
            "OPLOG->et",
            "OPLOG->ou"
   		};


public String[][] tableSLR = 
    {
        {"etat/VT", "debut", "fin", "id", ";", "entier", "reel", "chaine", "<-", "lire", "afficher", "(", ")", "si", "alors", "sinon", "finsi", "tantque", "faire", "fintq", "Vrai", "Faux", "+", "-", "*", "/", "<", ">", "=", "et", "ou", "$", "P", "LD", "D", "T", "LI", "I", "A", "L", "EC", "C", "B", "EX", "BOOL", "OP", "OPARTH", "OPLOG", "err"},
        {"0", "err", "err", "err", "err", "s4", "s5", "s7", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s8", "s9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "1", "2", "3", "err", "err", "err", "err", "err", "err", "err", "err", "6", "err", "err", "err", "err"},
        {"1", "s10", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"2", "r1", "err", "err", "err", "s4", "s5", "s7", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s8", "s9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "11", "2", "3", "err", "err", "err", "err", "err", "err", "err", "err", "6", "err", "err", "err", "err"},
        {"3", "err", "err", "s12", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"4", "err", "err", "r4", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"5", "err", "err", "r5", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"6", "err", "err", "r6", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"7", "err", "err", "r7", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"8", "err", "err", "r24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"9", "err", "err", "r25", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"10", "err", "err", "s20", "err", "err", "err", "err", "err", "s21", "s22", "err", "err", "s23", "err", "err", "err", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "13", "14", "15", "16", "17", "18", "19", "err", "err", "err", "err", "err", "err"},
        {"11", "r2", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"12", "err", "err", "err", "s25", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"13", "err", "s26", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"14", "err", "err", "err", "s27", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"15", "err", "err", "err", "r10", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"16", "err", "err", "err", "r11", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"17", "err", "err", "err", "r12", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"18", "err", "err", "err", "r13", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"19", "err", "err", "err", "r14", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"20", "err", "err", "err", "err", "err", "err", "err", "s28", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"21", "err", "err", "s29", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"22", "err", "err", "s30", "err", "err", "err", "err", "err", "err", "err", "s31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"23", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s32", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s33", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"25", "r3", "err", "err", "err", "r3", "r3", "r3", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r3", "r3", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"26", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "Accept", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"27", "err", "r8", "s20", "err", "err", "err", "err", "err", "s21", "s22", "err", "err", "s23", "err", "r8", "r8", "s24", "err", "r8", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "34", "14", "15", "16", "17", "18", "19", "err", "err", "err", "err", "err", "err"},
        {"28", "err", "err", "s36", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "35", "err", "err", "err", "err", "err"},
        {"29", "err", "err", "err", "r16", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"30", "err", "err", "err", "r17", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"31", "err", "err", "err", "err", "err", "err", "s37", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"32", "err", "err", "s36", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "38", "err", "err", "err", "err", "err"},
        {"33", "err", "err", "s36", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "39", "err", "err", "err", "err", "err"},
        {"34", "err", "r9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r9", "r9", "err", "err", "r9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"35", "err", "err", "err", "r15", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "43"},
        {"36", "err", "err", "err", "r23", "err", "err", "err", "err", "err", "err", "err", "r23", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s43", "s44", "s45", "s46", "s47", "s48", "s49", "s50", "s51", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "40", "41", "42", "err"},
        {"37", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s52", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"38", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s53", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s54", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"40", "err", "err", "s55", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"41", "err", "err", "r26", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"42", "err", "err", "r27", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"43", "err", "err", "r28", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"44", "err", "err", "r29", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"45", "err", "err", "r30", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"46", "err", "err", "r31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"47", "err", "err", "r32", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"48", "err", "err", "r33", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"49", "err", "err", "r34", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"50", "err", "err", "r35", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"51", "err", "err", "r36", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"52", "err", "err", "err", "r18", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"53", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s56", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"54", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s57", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"55", "err", "err", "err", "r22", "err", "err", "err", "err", "err", "err", "err", "r22", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"56", "err", "err", "s20", "err", "err", "err", "err", "err", "s21", "s22", "err", "err", "s23", "err", "err", "err", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "58", "14", "15", "16", "17", "18", "19", "err", "err", "err", "err", "err", "err"},
        {"57", "err", "err", "s20", "err", "err", "err", "err", "err", "s21", "s22", "err", "err", "s23", "err", "err", "err", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "59", "14", "15", "16", "17", "18", "19", "err", "err", "err", "err", "err", "err"},
        {"58", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s60", "s61", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"59", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s62", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"60", "err", "err", "s20", "err", "err", "err", "err", "err", "s21", "s22", "err", "err", "s23", "err", "err", "err", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "63", "14", "15", "16", "17", "18", "19", "err", "err", "err", "err", "err", "err"},
        {"61", "err", "err", "err", "r20", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"62", "err", "err", "err", "r21", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"63", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s64", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
        {"64", "err", "err", "err", "r19", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"}   
    };
    
//[0]

    public Stack<String> stackState = new Stack<>();
    
    
    public Stack<String> analyse = new Stack<>();
    
    public Stack<String> stackSymbol = new Stack<>();
    public String strInput ;
    
   
    public String action = "";
    
    
    
    int index = 0;

    
    public void analyzeSLnew(List<Token> token) {
    	
        action = "";
        index = 0;
       
        analyse.push("0");
        
        System.out.println("********pile     	    Entrée            Action***********");
        this.AfficherSLRnew(token);
        String tt;
       while(index<token.size()) 
        
        {
            if (token.get(index).getType() == TokenType.ID)
            {
                tt = "id";
            }else
            {
                tt = token.get(index).getValue();
            }
            String s = analyse.peek();
            
            String act=Action(s,tt);
                      System.out.println(act);

            if (act.charAt(0) == 's') {
            	
            	
                //stackState.push(Action(s, ch[index]).substring(1));
                //stackSymbol.push(ch[index]);
                
                analyse.push(tt);
                analyse.push(act.substring(1));
               
                
                
              
                index++;
                action = "shift ";
                
                AfficherSLRnew(token);
            }
            // Réduction
            else if (act.charAt(0) == 'r') {
                //
                String str = LRGS[Integer.parseInt(act.substring(1))];
               
                String tabparties[]= str.split("->");
                
                
                String Partiegauche=tabparties[0];
                //System.out.println("Partiegauche"+Partiegauche); 
                
                String Partiedroite=tabparties[1];
                //System.out.println("Partiedroite"+Partiedroite); 
                
                String tabtoken[]= Partiedroite.split(" ");
                int taillepile= tabtoken.length +tabtoken.length;
                //System.out.println("taillepile"+taillepile);
               
                for (int i = 0; i < taillepile; i++) {
                	
                  
                    
                    analyse.pop();
                    
                }
                String sommetpile = analyse.peek();
                analyse.push(Partiegauche);
                
                analyse.push(Action(sommetpile, Partiegauche));
                
               
                action = "reduce:" + str;
                AfficherSLRnew(token);
            } 
            //acceptation
            else if ("Accept".equals(act))
            	{
            	System.out.println("analyze SLR successfully"); 
            	break;}
            	
            else
            	//erreur
            	{
            	
            	//System.out.println("texterreur"+Action(s,ch[index])+s+ch[index]+index); 
            	System.out.println("analyze SLR failled"); 
        	break;
            	}
               
        }
        
    }
    
    
    
    
    public String Action(String s, String a) {
        for (int i = 1; i <tableSLR.length ; i++)
            if (tableSLR[i][0].equals(s))
                for (int j = 1; j <tableSLR[0].length; j++)
                    if (tableSLR[0][j].equals(a))
                        return tableSLR[i][j];
        return "err";
    }

    public void AfficherSLRnew(List<Token>token) {
        //  SLR
    	
    	
    	String ss= "-------";
    	String ss1= "-------";
    	 int taillepile=analyse.size();
    	int taillepilediv2= taillepile /2;
         for(int i=0;i<taillepilediv2;i++)
     		ss=ss + "-------" ;
         int tailleinput=token.size();
         for(int i=0;i<tailleinput;i++)
     		ss1=ss1 + "-------" ;
    	
    	
    	
        
       
        strInput="";
        for(int i=index; i<tailleinput;i++)
        	strInput= strInput+ token.get(i).getValue()+" ";
       
        System.out.printf("%s", analyse + ss1);
        System.out.printf("%s", strInput+ ss);
        System.out.printf("%s", action);
        System.out.println();
    }

    public void ouput() {
        for (int i = 0; i < LRGS.length ; i++) {
            System.out.println(i+" "+LRGS[i]);
        }
        System.out.println("**********Tableau SLR¨********");

        for (int i = 0; i < tableSLR.length ; i++) {
            for (int j = 0; j <tableSLR[i].length; j++) {
                System.out.printf("%6s", tableSLR[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********Fin tableau SLR********");

    }
}