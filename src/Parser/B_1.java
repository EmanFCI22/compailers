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
//"new" Ex2 
public class B_1 extends B
{
    Token neww;
    Ex2 ex2;

    public B_1(Token neww, Ex2 ex2) {
        this.neww = neww;
        this.ex2 = ex2;
    }
    
    @Override
    public void printNode() 
    {
        System.out.println(neww.value);
        ex2.printNode();

    }
    
    
}
