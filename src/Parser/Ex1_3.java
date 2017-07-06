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
//"[" Expression "]" 
public class Ex1_3 extends Ex1
{
    Token leftSquareBracket;
    Expression expression;
    Token rightSquareBracket;

    public Ex1_3(Token leftSquareBracket, Expression expression, Token rightSquareBracket) {
        this.leftSquareBracket = leftSquareBracket;
        this.expression = expression;
        this.rightSquareBracket = rightSquareBracket;
    }

    
    
    @Override
    public void printNode() 
    {
        System.out.println(leftSquareBracket.value);

        expression.printNode();
        System.out.println(rightSquareBracket.value);

    }
    
}
