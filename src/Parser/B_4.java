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
public class B_4 extends B
{
    Token token;// <INTEGER_LITERAL> | "true"| "false" | Identifier | "this" 

    public B_4(Token token) {
        this.token = token;
    }
    
    
    @Override
    public void printNode() 
    {
        System.out.println(token.value);
    }
    
}
