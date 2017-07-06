/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;
import Lexical.Token;

/**
 *
 * @author rawan
 */
  //  "int" "[" Expression "]" ok

public class Ex2_1 extends Ex2{

    Token intt;
    Token leftSquareBracket;
    Expression expression;
    Token rightSquareBracket;

    public Ex2_1(Token intt, Token leftSquareBracket, Expression expression, Token rightSquareBracket) {
        this.intt = intt;
        this.leftSquareBracket = leftSquareBracket;
        this.expression = expression;
        this.rightSquareBracket = rightSquareBracket;
    }
    
    @Override
    public void printNode() 
    {
        System.out.println(intt.value);
        System.out.println(leftSquareBracket.value);

        expression.printNode();
        System.out.println(rightSquareBracket.value);

    }
}
