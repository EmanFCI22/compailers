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
// ( "&&" | "<" | "+" | "-" | "*" ) Expression
public class Ex1_2 extends Ex1
{
    Token operator;
    Expression expression;

    public Ex1_2(Token operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    
    @Override
    public void printNode() 
    {
        System.out.println(operator.value);

        expression.printNode();
    }
    
}
