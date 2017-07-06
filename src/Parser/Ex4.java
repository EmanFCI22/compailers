/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

/**
 *
 * @author rawan
 */
//Ex4 ::= ( Ex1 Ex4 ) ? ok
public class Ex4 implements Node
{
    Ex1 ex1;
    Ex4 ex4;

    public Ex4(Ex1 ex1, Ex4 ex4) {
        this.ex1 = ex1;
        this.ex4 = ex4;
    }
    
    
    @Override
    public void printNode() 
    {

        ex1.printNode();
        if(ex4!=null) 
            ex4.printNode() ;

    }

  
    
}
