/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Lexical.Token;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rawan
 */
public class SA
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        ArrayList<Token>tokens = readFile.ReadFile("Tokens.txt");
        Parser2 parser = new Parser2(tokens);
        Goal goal = parser.parse();
        goal.printNode();
        
    }
    
}
