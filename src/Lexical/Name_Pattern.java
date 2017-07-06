package Lexical;


import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FCI User
 */
public class Name_Pattern 
{
    public String Name;
    public Pattern pattern;

    public Name_Pattern(String Name, String pattern) {
        this.Name = Name;
        this.pattern = Pattern.compile(pattern);
    }
    
    
}
