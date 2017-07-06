package Parser;
import Lexical.Token;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rawan
 */
//"." Identifier "(" ( Expression ( "," Expression )* )? ")"
public class Ex3_2 extends Ex3
{

    Token identifier;
    Token leftCircleBracket;
    Expression expression; 
    //Array list of comma expression
    ArrayList<Pair<Token,Expression>>commaExpress;
    Token rightCircleBracket;

    public Ex3_2( Token identifier, Token leftCircleBracket, 
            ArrayList<Pair<Token,Expression>>commaExpress, Expression expression
            , Token rightCircleBracket) {

        this.identifier = identifier;
        this.leftCircleBracket = leftCircleBracket;
        this.expression = expression;
        this.rightCircleBracket = rightCircleBracket;
        this.commaExpress=commaExpress;
    }
    
    
    @Override
    public void printNode()
    {
        System.out.println(identifier.value);
        System.out.println(leftCircleBracket.value);
        
        if(expression!=null) 
        {
            expression.printNode() ;
            if (commaExpress!=null)
            {
                for (Pair<Token,Expression>p : commaExpress)
                {
                    System.out.println(p.getComma().value);
                    p.getExpression().printNode();

                }
            }
            
        }
        System.out.println(rightCircleBracket.value);

    }

    

    
}
