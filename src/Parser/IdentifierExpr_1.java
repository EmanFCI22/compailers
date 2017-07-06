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
//IdentifierExpr ::= "=" Expression ";" 

public class IdentifierExpr_1 extends IdentifierExpr {

    Token EQUAL;
    Expression expression;
    Token SEMICOLON;

    public IdentifierExpr_1(Token EQUAL, Expression expression, Token SEMICOLON) {
        this.EQUAL = EQUAL;
        this.expression = expression;
        this.SEMICOLON = SEMICOLON;
    }
    
    @Override
    public void printNode() {
        System.out.println(EQUAL.value);
        expression.printNode();
        System.out.println(SEMICOLON.value);
    }
    
}
