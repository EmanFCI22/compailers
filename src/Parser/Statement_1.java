/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;
import Lexical.Token;
import java.util.ArrayList;

/**
 *
 * @author hend
 */
//Statement ::= "{" ( Statement )* "}"
public class Statement_1 extends Statement {
    
    Token LEFT_CURLY_B;
    ArrayList<Statement> statements;
    Token RIGHT_CURLY_B;

    public Statement_1(Token LEFT_CURLY_B, ArrayList<Statement> statements, Token RIGHT_CURLY_B) {
        this.LEFT_CURLY_B = LEFT_CURLY_B;
        this.statements = new ArrayList<Statement>(statements);
        this.RIGHT_CURLY_B = RIGHT_CURLY_B;
    }

    @Override
    public void printNode() 
    {
        System.out.println(LEFT_CURLY_B.value);
        for (Statement statement : statements) {
            statement.printNode();
        }
        System.out.println(RIGHT_CURLY_B.value);
    }
}
