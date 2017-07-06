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
//Statement ::= "while" "(" Expression ")" Statement 

public class Statement_3 extends Statement {
    
    Token WHILE;
    Token LEFT_ROUND_B;
    Expression expression;
    Token RIGHT_ROUND_B;
    Statement statement;

    public Statement_3(Token WHILE, Token LEFT_ROUND_B, Expression expression, Token RIGHT_ROUND_B, Statement statement) {
        this.WHILE = WHILE;
        this.LEFT_ROUND_B = LEFT_ROUND_B;
        this.expression = expression;
        this.RIGHT_ROUND_B = RIGHT_ROUND_B;
        this.statement = statement;
    }

    @Override
    public void printNode() 
    {
        System.out.println(WHILE.value);
        System.out.println(LEFT_ROUND_B.value);
        expression.printNode();
        System.out.println(RIGHT_ROUND_B.value);
        statement.printNode();
    }
}
