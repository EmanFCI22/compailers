/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;
import Lexical.Token;

/**
 *
 * @author hend
 */
//Statement ::= Identifier  IdentifierExpr

public class Statement_5 extends Statement {
    
    Token id;
    IdentifierExpr identifierExpr;

    public Statement_5(Token id, IdentifierExpr identifierExpr) {
        this.id = id;
        this.identifierExpr = identifierExpr;
    }

    @Override
    public void printNode() 
    {
        System.out.println(id.value);
        identifierExpr.printNode();
    }
}
