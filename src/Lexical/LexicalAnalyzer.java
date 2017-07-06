package Lexical;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
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
public class LexicalAnalyzer
{
    
    public ArrayList<Name_Pattern>patterns=new ArrayList<Name_Pattern>();
    
    private void initializePatterns()
    {

        patterns.add(new Name_Pattern("COMMENT2","/\\*.*\\*/"));
        patterns.add(new Name_Pattern("STRING_LITERAL","\".*\""));
        patterns.add(new Name_Pattern("COMMENT1","//.*"));
        patterns.add(new Name_Pattern("A_CHAR","'(\\\\r|\\\\f|\\\"|\\\\0|\\\\b"
                + "|\\\\t|.|\\\\n)'"));
        patterns.add(new Name_Pattern("SEMICOLON",";"));
        patterns.add(new Name_Pattern("SQUOTE","'"));
        patterns.add(new Name_Pattern("DQUOTE","\\b\"\\b"));
        patterns.add(new Name_Pattern("COMMENT_L","/\\*"));
        patterns.add(new Name_Pattern("COMMENT_R","\\*/"));  
        patterns.add(new Name_Pattern("EOL","\n"));
        patterns.add(new Name_Pattern("INT","\\bint\\b"));
        patterns.add(new Name_Pattern("PLUS","\\+"));
        patterns.add(new Name_Pattern("LEFT_CURLY_B","\\{"));
        patterns.add(new Name_Pattern("RIGHT_CURLY_B","\\}"));
        patterns.add(new Name_Pattern("LEFT_SQUARE_B","\\["));
        patterns.add(new Name_Pattern("RIGHT_SQUARE_B","\\]"));
        patterns.add(new Name_Pattern("LEFT_ROUND_B","\\("));
        patterns.add(new Name_Pattern("RIGHT_ROUND_B","\\)"));
        patterns.add(new Name_Pattern("COMMA",","));
        patterns.add(new Name_Pattern("FLOAT_LITERAL","\\b[+-]?\\d+\\.\\d+\\b"));
        patterns.add(new Name_Pattern("SYSTEM.OUT.PRINTLN","\\bSystem\\.out\\.println\\b"));
        patterns.add(new Name_Pattern("DOT","\\."));
        patterns.add(new Name_Pattern("NOT","!"));
        patterns.add(new Name_Pattern("EQUAL","="));
        patterns.add(new Name_Pattern("AND","&&"));
        patterns.add(new Name_Pattern("MINUS","-"));
        patterns.add(new Name_Pattern("MULTIPLY","\\*"));
        patterns.add(new Name_Pattern("LESSTHAN","<"));
        patterns.add(new Name_Pattern("GREATERTHAN",">"));
        patterns.add(new Name_Pattern("IF","\\bif\\b"));
        patterns.add(new Name_Pattern("ELSE","\\belse\\b"));
        patterns.add(new Name_Pattern("MAIN","\\bmain\\b"));
        patterns.add(new Name_Pattern("THIS","\\bthis\\b"));
        patterns.add(new Name_Pattern("TRUE","\\btrue\\b"));
        patterns.add(new Name_Pattern("VOID","\\bvoid\\b"));
        
        patterns.add(new Name_Pattern("CLASS","\\bclass\\b"));
        patterns.add(new Name_Pattern("FALSE","\\bfalse\\b"));
        patterns.add(new Name_Pattern("WHILE","\\bwhile\\b"));
        patterns.add(new Name_Pattern("LENGTH","\\blength\\b"));
        patterns.add(new Name_Pattern("PUBLIC","\\bpublic\\b"));
        patterns.add(new Name_Pattern("RETURN","\\breturn\\b"));
        patterns.add(new Name_Pattern("STATIC","\\bstatic\\b"));
        patterns.add(new Name_Pattern("NEW","\\bnew\\b"));
        patterns.add(new Name_Pattern("STRING","\\bString\\b"));
        patterns.add(new Name_Pattern("FLOAT","\\bFloat\\b"));
        patterns.add(new Name_Pattern("CHARACTER","\\bCharacter\\b"));
        patterns.add(new Name_Pattern("BOOLEAN","\\bBoolean\\b"));
        patterns.add(new Name_Pattern("EXTENDS","\\bextends\\b"));
        patterns.add(new Name_Pattern("ID","\\b[a-zA-Z_]\\w*\\b"));
        patterns.add(new Name_Pattern("LENGTH","\\blength\\b"));

        patterns.add(new Name_Pattern("INTEGRAL_LITERAL","\\b[+-]?\\d+\\b"));
        
              
        
        
    }

    public LexicalAnalyzer() 
    {
        initializePatterns();
    }
    
    

    class pair{

        public Integer index;
        public Token token;
        
        public pair(int i, Token t) {
            this.index = i;
            this.token = t;
        }
    }
     /*
        loop to patterns and find them in input and delete them and check for erors
    */
    ArrayList<pair> leximes=new ArrayList();
    public ArrayList<Token> lexicalization(String myInput){
        myInput = myInput.replaceAll("'", "\\\'");
        Matcher m=null;
        for (int i = 0; i < patterns.size(); i++) {
            Name_Pattern p =patterns.get(i);
            m=p.pattern.matcher(myInput);
            while(m.find())
            {
               //System.out.println(m.group());
                String match =m.group();
                //System.out.println(match);
                myInput=m.replaceFirst(String.join("",
                        Collections.nCopies(match.length(), " ")));
                       
                //System.out.println(myInput);
                leximes.add(new pair(m.start(),new Token(p.Name,match)));
                m=p.pattern.matcher(myInput);
            }
        }
        
        boolean b=true;
        for (int i = 0; i < myInput.length(); i++) {
            if(myInput.charAt(i)!=' '&&myInput.charAt(i)!='\n'&&myInput.charAt(i)!='\t'){
                if(b){
                    System.out.print("error at "+i+" ");
                    System.out.println(myInput.charAt(i));
                    b=!b;
                }else{
                    //System.out.print(myInput.charAt(i));
                }
                
            }
            else b=!b;
        }
        Collections.sort(leximes, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.index.compareTo(o2.index);
            }
        });
        check();
        ArrayList<Token>tokens=new ArrayList<>();
        for (pair l:leximes)
        {
            tokens.add(l.token);
        }
        
        return tokens;
    }
    public void check()
    {
    	for (int i=0;i<leximes.size();i++)
    	{
    		pair l=leximes.get(i);
    		for(int j=i+1;j<leximes.size();j++)
    		{
    			pair x=leximes.get(j);
    			if ((l.index<x.index) &&((l.token.value.length()+l.index)>=(x.token.value.length()+x.index)))
    			{
    				
    				l.token.value=l.token.value.substring(0, x.index-l.index)+x.token.value+l.token.value.substring((x.token.value.length()+(x.index-l.index)));
    				leximes.remove(j);
    			}
    		}
    	}
    }
}