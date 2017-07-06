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
public class Ex3_1 extends Ex3
{
    Token length;

    public Ex3_1(Token length) {
        this.length = length;
    }
    
    @Override
    public void printNode() 
    {
        System.out.println(length.value);

    }
    
    
}
