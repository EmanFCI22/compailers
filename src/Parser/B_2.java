/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;
import Lexical.Token;;

/**
 *
 * @author rawan
 */
//"!" Expression
public class B_2 extends B
{
    Token exclamationMark;
    Expression expression;

    public B_2(Token exclamationMark, Expression expression) {
        this.exclamationMark = exclamationMark;
        this.expression = expression;
    }

    
    @Override
    public void printNode() 
    {
        System.out.println(exclamationMark.value);
        expression.printNode();

    }
    
    
}
