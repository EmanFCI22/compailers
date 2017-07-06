package Lexical;


import Parser.Parser2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author FCI User
 */
public class LA {

    public static void writeTokensToFile(ArrayList<Token> tokens) throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
    	try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Tokens.txt"), "utf-8"))) 
        {
    		for (int i=0;i<tokens.size();i++)
    			writer.write("< "+tokens.get(i).Type+" > : -"+tokens.get(i).value+"-\n");
                
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static String readInputFile(String fileName)
    {
    	String stream="";
    	System.out.println("Reading File from Java code");
        try
        {

           FileReader inputFile = new FileReader(fileName);

           BufferedReader bufferReader = new BufferedReader(inputFile);

           String line;

           if ((line = bufferReader.readLine()) != null)
        	   stream+=line;
           while ((line = bufferReader.readLine()) != null)   {
        	   stream+='\n';
        	   stream+=line;
           }
           bufferReader.close();
        }
        catch(Exception e)
        {
           System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
        return stream;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //input file
    	//System.out.println("\\");
    	String input=readInputFile("input.txt");
        System.out.println(input+"\n\n---------\n");
        LexicalAnalyzer la=new LexicalAnalyzer();
        ArrayList<Token> tokens=new ArrayList<Token>(la.lexicalization(input));
        tokens.add(new Token("EOF"," "));
        writeTokensToFile(tokens);
        
       
    }
    
}
