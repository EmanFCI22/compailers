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
//Statement ::= "if" "(" Expression ")" Statement  Ifstm 

public class Statement_2 extends Statement {
    
    Token IF;
    Token LEFT_ROUND_B;
    Expression expression;
    Token RIGHT_ROUND_B;
    Statement statement;
    Ifstm ifstm;

    public Statement_2(Token IF, Token LEFT_ROUND_B, Expression expression, Token RIGHT_ROUND_B, Statement statement, Ifstm ifstm) {
        this.IF = IF;
        this.LEFT_ROUND_B = LEFT_ROUND_B;
        this.expression = expression;
        this.RIGHT_ROUND_B = RIGHT_ROUND_B;
        this.statement = statement;
        this.ifstm = ifstm;
    }

    @Override
    public void printNode() 
    {
        System.out.println(IF.value);
        System.out.println(LEFT_ROUND_B.value);
        expression.printNode();
        System.out.println(RIGHT_ROUND_B.value);
        statement.printNode();
        if(ifstm!=null)
            ifstm.printNode();
    }
}
