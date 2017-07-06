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
//Ex1 ::= "." Ex3 
public class Ex1_1 extends Ex1
{
    Token dot;
    Ex3 ex3;

    public Ex1_1(Token dot, Ex3 ex3) {
        this.dot = dot;
        this.ex3 = ex3;
    }

    @Override
    public void printNode() 
    {
        System.out.println(dot.value);

        ex3.printNode();

    }
    
}
