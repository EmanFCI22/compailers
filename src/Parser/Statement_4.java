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
//Statement ::= "System.out.println" "(" Expression ")" ";"

public class Statement_4 extends Statement {
    
    Token PRINTLN;
    Token LEFT_ROUND_B;
    Expression expression;
    Token RIGHT_ROUND_B;
    Token SeMICOLON;

    public Statement_4(Token PRINTLN, Token LEFT_ROUND_B, Expression expression, Token RIGHT_ROUND_B, Token SeMICOLON) {
        this.PRINTLN = PRINTLN;
        this.LEFT_ROUND_B = LEFT_ROUND_B;
        this.expression = expression;
        this.RIGHT_ROUND_B = RIGHT_ROUND_B;
        this.SeMICOLON = SeMICOLON;
    }

    
    @Override
    public void printNode() 
    {
        System.out.println(PRINTLN.value);
        System.out.println(LEFT_ROUND_B.value);
        expression.printNode();
        System.out.println(RIGHT_ROUND_B.value);
        System.out.println(SeMICOLON.value);
    }
}
