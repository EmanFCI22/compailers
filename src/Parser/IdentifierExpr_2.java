/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;
import Lexical.Token;

// IdentifierExpr ::= "[" Expression "]" "=" Expression ";"
public class IdentifierExpr_2 extends IdentifierExpr {

    Token LEFT_SQUARE_B;
    Expression expression1;
    Token RIGHT_SQUARE_B;
    Token EQUAL;
    Expression expression2;
    Token SEMICOLON;

    public IdentifierExpr_2(Token LEFT_SQUARE_B, Expression expression1, Token RIGHT_SQUARE_B, Token EQUAL, Expression expression2, Token SEMICOLON) {
        this.LEFT_SQUARE_B = LEFT_SQUARE_B;
        this.expression1 = expression1;
        this.RIGHT_SQUARE_B = RIGHT_SQUARE_B;
        this.EQUAL = EQUAL;
        this.expression2 = expression2;
        this.SEMICOLON = SEMICOLON;
    }

    @Override
    public void printNode() {
        System.out.println(LEFT_SQUARE_B.value);
        expression1.printNode();
        System.out.println(RIGHT_SQUARE_B.value);
        System.out.println(EQUAL.value);
        expression2.printNode();
        System.out.println(SEMICOLON.value);
    }
    
}
