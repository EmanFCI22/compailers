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
//"(" Expression ")"
public class B_3 extends B
{
    Token leftCircleBracket;
    Expression expression;
    Token rightCircleBracket;

    public B_3(Token leftCircleBracket, Expression expression, Token rightCircleBracket) {
        this.leftCircleBracket = leftCircleBracket;
        this.expression = expression;
        this.rightCircleBracket = rightCircleBracket;
    }


    
    
    @Override
    public void printNode() 
    {
        System.out.println(leftCircleBracket.value);
        expression.printNode();
        System.out.println(rightCircleBracket.value);
    }
    
}
