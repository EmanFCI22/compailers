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
//Expression ::= B Ex4 ok
public class Expression implements Node
{
    B b;
    Ex4 ex4;

    public Expression(B b, Ex4 ex4)
    {
        this.b = b;
        this.ex4 = ex4;
    }
    

    @Override
    public void printNode() 
    {

        b.printNode();
        if(ex4!=null) 
            ex4.printNode() ;
    }
    
    
}
