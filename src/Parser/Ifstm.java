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
//Ifstm ::= ( "else" Statement ) ?
public class Ifstm implements Node {
    Token ELSE;
    Statement statement;

    public Ifstm(Token ELSE, Statement statement) {
        this.ELSE = ELSE;
        this.statement = statement;
    }
    
    @Override
    public void printNode() 
    {
        if(ELSE == null){
        } else {
            System.out.println(ELSE.value);
            statement.printNode();
        }
    }
}
