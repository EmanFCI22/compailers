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
//" Identifier "(" ")" 
public class Ex2_2 extends Ex2
{
    Token identifier;
    Token leftCircleBracket;
    Token rightCircleBracket;

    public Ex2_2(Token identifier, Token leftCircleBracket, Token rightCircleBracket) {
        this.identifier = identifier;
        this.leftCircleBracket = leftCircleBracket;
        this.rightCircleBracket = rightCircleBracket;
    }

    
    @Override
    public void printNode() 
    {
        System.out.println(identifier.value);
        System.out.println(leftCircleBracket.value);
        System.out.println(rightCircleBracket.value);

    }
    
}
