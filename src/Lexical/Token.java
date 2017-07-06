package Lexical;
/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FCI User
 */
public class Token {
    public String Type;
    public String value;

    public Token(String type, String value) 
    {
        this.Type=type;
        this.value=value;
    }

    @Override
    public String toString() 
    {
        return "< "+Type+" > : -"+value+"-\n";

    }
    
}
