/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Lexical.LexicalAnalyzer;
import Lexical.Token;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author rawan
 */
public class Parser2
{
    public static ArrayList<Token> tokens;
    public static int indexPointer=0;
    public Parser2(ArrayList<Token> tokens) 
    {
           this.tokens =tokens;
    }
    public  ArrayList<Token>getTokens(String fileName)
    {
            LexicalAnalyzer la = new LexicalAnalyzer();
            return la.lexicalization(fileName);
    }
    public  Goal parse()
    {
	return GoalRule();
    }


    //---------------------Rawan-----------------------
    private Expression ExpressionRule()
    {
        B b =BRule();
        if (b==null)
        {
            System.out.println("Syntax error expected B object");
            return null;
        }
        Ex4 ex4=Ex4Rule();
        return new Expression(b,ex4);

    }
//B ::= "new" Ex2 |  <INTEGER_LITERAL> | "true"| "false" | Identifier |
    //"this" | "!" Expression | "(" Expression ")"
    private B BRule() 
    {
        if (tokens.get(indexPointer).Type.equals("NEW"))
        {
            Token neww=tokens.get(indexPointer);
            indexPointer++;
            Ex2 ex2=Ex2Rule();
            if (ex2==null)
            {
                System.out.println("Syntax error expected Ex2 object");
                return null;
            }
            return new B_1(neww,ex2);
        }
        else if (tokens.get(indexPointer).Type.equals("INTEGRAL_LITERAL")
                ||tokens.get(indexPointer).Type.equals("TRUE")
                ||tokens.get(indexPointer).Type.equals("FALSE")
                ||tokens.get(indexPointer).Type.equals("ID")
                ||tokens.get(indexPointer).Type.equals("THIS"))
        {
            Token token=tokens.get(indexPointer);
            indexPointer++;
            return new B_4(token);
        }
        else if (tokens.get(indexPointer).Type.equals("NOT"))//////////////////////////////////////////////////////////////////////////////
        {
            Token not=tokens.get(indexPointer);
            indexPointer++;
            Expression expression=ExpressionRule();
            if(expression==null)
            {
                System.out.println("Syntax error expected Expression object");
                return null;
            }
            return new B_2(not,expression);
        }
        else if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type))
        {
            Token leftRoundBracket=tokens.get(indexPointer);
            indexPointer++;
            Expression expression=ExpressionRule();
            if(expression==null)
            {
                System.out.println("Syntax error expected Expression object");
                return null;
            }
            if ("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type))
            {
                Token rightRoundBracket=tokens.get(indexPointer);
                indexPointer++;
                return new B_3(leftRoundBracket,expression,rightRoundBracket);
            }
            else
            {
                System.out.println("Syntax error expected ) ");
                return null;
            }
        }
        else return null;
        
    }
    private Ex4 Ex4Rule() 
    {
        Ex1 ex1=Ex1Rule();
        if(ex1!=null)
        {
            Ex4 ex4=Ex4Rule();
            return new Ex4(ex1,ex4);
        }
        return null;
    }

   // Ex1 ::= "." Ex3 | ( "&&" | "<" | "+" | "-" | "*" ) Expression | "[" Expression "]" 
    private Ex1 Ex1Rule()
    {
        if (tokens.get(indexPointer).Type.equals("DOT"))
        {
            Token dot=tokens.get(indexPointer);
            indexPointer++;
            Ex3 ex3=Ex3Rule();
            if(ex3==null)
            {
                System.out.println("Syntax error expected Ex3 object");
                return null;
            }
            return new Ex1_1(dot,ex3);
        }
        else if (tokens.get(indexPointer).Type.equals("AND") ||
                tokens.get(indexPointer).Type.equals("LESSTHAN")||
                tokens.get(indexPointer).Type.equals("PLUS")||
                tokens.get(indexPointer).Type.equals("MINUS")||
                tokens.get(indexPointer).Type.equals("MULTIPLY"))
            
        {
            Token op=tokens.get(indexPointer);
            indexPointer++;
            Expression expression=ExpressionRule();
            if(expression==null)
            {
                System.out.println("Syntax error expected Expression object");
                return null;
            }
            return new Ex1_2(op,expression);
        }
        else if (tokens.get(indexPointer).Type.equals("LEFT_SQUARE_B"))
        {
            Token left=tokens.get(indexPointer);
            indexPointer++;
            Expression expression=ExpressionRule();
            if(expression==null)
            {
                System.out.println("Syntax error expected Expression object");
                return null;
            }
            if (tokens.get(indexPointer).Type.equals("RIGHT_SQUARE_B"))
            {
                Token right=tokens.get(indexPointer);
                indexPointer++;
                return new Ex1_3(left,expression,right);
            }
            else
            {
                System.out.println("Syntax error expected ] ");
                return null;
            }
        }
        else 
        {
            return null;
        }
        
    }
    
    //Ex2 ::= "int" "[" Expression "]"  | " Identifier "(" ")" 
    private Ex2 Ex2Rule()
    {
        
        if ("INT".equals(tokens.get(indexPointer).Type))
        {
            Token intt=tokens.get(indexPointer);
            indexPointer++;
            if ("LEFT_SQUARE_B".equals(tokens.get(indexPointer).Type))
            {
                Token leftSquaredBracket=tokens.get(indexPointer);
                indexPointer++;
                Expression exp=ExpressionRule();
                if(exp==null)
                {
                    System.out.println("Syntax error expected Expression object");
                    return null;
                }
                if ("RIGHT_SQUARE_B".equals(tokens.get(indexPointer).Type))
                {
                    Token rightSquaredBracket=tokens.get(indexPointer);
                    indexPointer++;
                    return new Ex2_1(intt,leftSquaredBracket,exp,rightSquaredBracket);
                }
                else
                {
                    System.out.println("Syntax error expected ] ");
                    return null;
                }
            }
            else 
            {
                System.out.println("Syntax error expected [ ");
                return null;    
            }
        }
        else if(tokens.get(indexPointer).Type.equals("ID"))
        {
            Token identifier=tokens.get(indexPointer);
            indexPointer++;
            if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type))
            {
                Token leftRoundBracket=tokens.get(indexPointer);
                indexPointer++;
                if ("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type))
                {
                    Token rightRoundBracket=tokens.get(indexPointer);
                    indexPointer++;
                    return new Ex2_2(identifier,leftRoundBracket,rightRoundBracket);
                }
                else
                {
                    System.out.println("Syntax error expected ) ");
                    return null;
                }
            }
            else 
            {
                System.out.println("Syntax error expected ( ");
                return null;    
            }
            
        }
        else 
        {
           
            return null;
        }
        
        
    }
//Ex3 ::= "length" | "." Identifier "(" ( Expression ( "," Expression )* )? ")"
    private Ex3 Ex3Rule() 
    {
        if ("LENGTH".equals(tokens.get(indexPointer).Type))
        {
            Token length=tokens.get(indexPointer);
            indexPointer++;
            return new Ex3_1(length);
        }
        else if ("ID".equals(tokens.get(indexPointer).Type))
        {
                Token identifier=tokens.get(indexPointer);
                indexPointer++;
                if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type))
                {
                    Token left=tokens.get(indexPointer);
                    indexPointer++;
                    if ("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type))
                    {
                        Token right=tokens.get(indexPointer);
                        indexPointer++;
                        //check again
                        return new Ex3_2(identifier,left,null,null,right);
                    }
                    else
                    {
                       Expression exp=ExpressionRule();
                        if(exp==null)
                        {
                            System.out.println("Syntax error expected Expression"
                                    + " object");
                            return null;
                        } 
                        else if ("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type))
                        {
                            Token right=tokens.get(indexPointer);
                            indexPointer++;
                            //check again
                            return new Ex3_2(identifier,left,null,exp,right);
                        }
                        else 
                        {
                            ArrayList<Pair<Token,Expression>>commaExp=
                                    new ArrayList<Pair<Token,Expression>>(); 
                            while ("COMMA".equals(tokens.get(indexPointer).Type))
                            {
                                
                                Token comma=tokens.get(indexPointer);
                                indexPointer++;
                                Expression exp2=ExpressionRule();
                                if(exp2==null)
                                {
                                    System.out.println("Syntax error expected Expression"
                                            + " object");
                                    return null;
                                } 
                                commaExp.add(new Pair<Token,Expression> (comma,exp2));
                                
                            }
                            if ("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type))
                            {
                                Token right=tokens.get(indexPointer);
                                indexPointer++;
                                //check again
                                return new Ex3_2(identifier,left,commaExp,exp,right);
                            }
                            else
                            {
                                System.out.println("Syntax error expected ) ");
                                return null;
                            }
                        }
                        
                    }
                   
                }
                else
                {
                    System.out.println("Syntax error expected ( ");
                    return null;  
                }
                
            }
            else
            {
                
                return null;  
            }
        
    }
    
    
    
    //---------------------EMAN -------------------------------
    private Goal GoalRule() 
    {
    	MainClass mainClass=MainClassRule();
        Goal goal =null;
    	if (mainClass==null){
    		System.out.println("Syntax error expected mainClass object");
    		return null;
    	}
    		
    	ArrayList<ClassDeclaration> classDeclaration = new ArrayList<ClassDeclaration>();
    	while(true)
    	{
    		ClassDeclaration classDec=ClassDeclarationRule();
    		if (classDec==null)
    		{
    			break;
    		}
    		classDeclaration.add(classDec);
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("EOF")){
    		goal =new Goal(mainClass, classDeclaration,tokens.get(indexPointer));
    		indexPointer++;
    	}else {
    		System.out.println("Syntax error expected EOF Token");
    		return null;
    	}
    	return goal;
        
    }
    private ClassDeclaration ClassDeclarationRule()
    {
    	//“class” Identifier ( “extends” Identifier  ) ? “{” ( VarDeclaration ) * ( MethodDeclaration ) * “}”
    	Token Class=null ;
    	Token ID1=null;
    	Token extend=null;
    	Token ID2=null;
    	Token leftCurlyB=null;
    	ArrayList<VarDeclaration> varDeclaration=new ArrayList<VarDeclaration>();
    	ArrayList<MethodDeclaration> methodDeclaration=new ArrayList<MethodDeclaration>();
    	Token rightCurlyB=null;
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("CLASS"))
    	{
    		Class=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		return null;
    	}
        if ("ID".equals(tokens.get(indexPointer).Type)){
            ID1=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }
        

    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("EXTENDS"))
    	{
    		extend=tokens.get(indexPointer);
    		indexPointer++;
    		if ("ID".equals(tokens.get(indexPointer).Type)){
                     ID2=tokens.get(indexPointer);
                     indexPointer++;
                    }
       
        

    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_CURLY_B"))
    	{
    		leftCurlyB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_CURLY_B Token");
    		return null;
    	}
    	
    	
    	while(true)
    	{
    		VarDeclaration varDec=VarDeclarationRule();
    		if (varDec==null)
    		{
    			break;
    		}
    		varDeclaration.add(varDec);
    	}
    	
    	while(true)
    	{
    		MethodDeclaration methDec=MethodDeclarationRule();
    		if (methDec==null)
    		{
    			break;
    		}
    		methodDeclaration.add(methDec);
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_CURLY_B"))
    	{
    		rightCurlyB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_CURLY_B Token");
    		return null;
    	}
    	ClassDeclaration classDec=new ClassDeclaration(Class, ID1, extend,
    			ID2, leftCurlyB, varDeclaration, methodDeclaration, rightCurlyB);
    	return classDec;
    }
    private VarDeclaration VarDeclarationRule()
    {
    	//VarDeclaration : := Type Identifier “;”
    	Type type=null;
    	Token ID=null;
    	Token semi=null;
    	
    	type=TypeRule();
    	if (type ==null)
    	{
    		return null;
    	}
        if ("ID".equals(tokens.get(indexPointer).Type)){
            ID=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }

    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("SEMICOLON"))
    	{
    		semi=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected SEMICOLON Token");
    		return null;
    	}
    	VarDeclaration vardec=new VarDeclaration(type, ID, semi);
    	return vardec;
    }
    private Type2 Type2Rule()
    {
    	Token leftSquareB=null;
    	Token rightSquareB = null;
    	if ((tokens.size()>indexPointer+1)&&tokens.get(indexPointer).Type.equals("LEFT_SQUARE_B")&&
    			tokens.get((indexPointer+1)).Type.equals("RIGHT_SQUARE_B"))
    	{
    		leftSquareB=tokens.get(indexPointer);
    		indexPointer++;
    		rightSquareB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	Type2 type2=new Type2(leftSquareB, rightSquareB);
    	return type2;
    }
    private Type TypeRule()
    {
    	Token type=null;
    	Type2 type2=null;
    	Type t;
    	if((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("String"))
    	{
    		type=tokens.get(indexPointer);
    		indexPointer++;
    		type2=Type2Rule();
    		t=new Type_1(type,type2);
    		
    	}
    	else if((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("BOOLEAN"))
    	{
    		type=tokens.get(indexPointer);
    		indexPointer++;
    		type2=Type2Rule();
    		t=new Type_2(type,type2);
    		
    	}
    	else if((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("FLOAT"))
    	{
    		type=tokens.get(indexPointer);
    		indexPointer++;
    		type2=Type2Rule();
    		t=new Type_3(type,type2);
    		
    	}
    	else if((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("INT"))
    	{
    		type=tokens.get(indexPointer);
    		indexPointer++;
    		type2=Type2Rule();
    		t=new Type_4(type,type2);
    		
    	}
    	else if((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("CHARACTER"))
    	{
    		type=tokens.get(indexPointer);
    		indexPointer++;
    		type2=Type2Rule();
    		t=new Type_5(type,type2);
    		
    	}
    	else 
    	{
    		return null;
    	}
    	return t;
    }
    private MethodDeclaration MethodDeclarationRule()
    {
    	// ( “public” | “private” ) Type Identifier “(” (Type Identifier ( “,”Type Identifier ) ? “)” “{” (VarDeclaration ) * (Statement ) * “return” Expression “;” “}”
    	Token P=null;
    	Type type1=null;
    	Token ID1=null;
    	Token leftRoundB=null;
    	Type type2=null;
    	Token ID2=null;
    	Token comma=null; 
    	Type type3=null;
    	Token ID3=null;
    	Token rightRoundB=null;
    	Token leftCurlyB=null;
    	ArrayList<VarDeclaration> varDeclaration=new ArrayList<VarDeclaration>();
    	ArrayList<Statement> statement=new ArrayList<Statement>();
    	Token Return=null;
    	Expression expression=null;
    	Token semi=null;
    	Token rightCurlyB=null;
    	if ((tokens.size()>indexPointer)&&(tokens.get(indexPointer).Type.equals("PUBLIC")|tokens.get(indexPointer).Type.equals("PRIVATE")))
    	{
    		P=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		return null;
    	}
    	type1=TypeRule();
    	if (type1==null)
    	{
    		System.out.println("Syntax error expected type object");
    		return null;
    	}
    	if ("ID".equals(tokens.get(indexPointer).Type)){
            ID1=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }

    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_ROUND_B"))
    	{
    		leftRoundB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_ROUND_B Token");
    		return null;
    	}
    	type2=TypeRule();
    	if (type2==null)
    	{
    		System.out.println("Syntax error expected type object");
    		return null;
    	}
    	if ("ID".equals(tokens.get(indexPointer).Type)){
            ID2=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }

    	
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("COMMA"))
    	{
    		int tmp1=indexPointer;
    		indexPointer++;
    		type3=TypeRule();
    		if (type3!=null)
    		{
    			if ("ID".equals(tokens.get(indexPointer).Type)){
                            ID3=tokens.get(indexPointer);
                            comma=tokens.get(tmp1);
                                indexPointer++;
                        }
                        else
                        {
                           ID3=null;
    				type3=null;
    				indexPointer=tmp1;
                        }
    		}
    		else {
    			type3=null;
    			indexPointer=tmp1;
    		}
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_ROUND_B"))
    	{
    		rightRoundB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_ROUND_B Token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_CURLY_B"))
    	{
    		leftCurlyB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_CURLY_B Token");
    		return null;
    	}
    	
    	while(true)
    	{
    		
    		VarDeclaration varDec=VarDeclarationRule();
    		if (varDec==null)
    		{

    			break;
    		}
                else
                    varDeclaration.add(varDec);
                
    	}
    	
    	while(true)
    	{
    		Statement stat=StatementRule();
    		if (stat==null)
    		{
    			break;
    		}
    		statement.add(stat);
    	}
    	
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RETURN"))
    	{
    		Return=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RETURN Token");
    		return null;
    	}
    	
    	expression=ExpressionRule();
    	if (expression==null)
    	{
    		System.out.println("Syntax error expected Expression object");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("SEMICOLON"))
    	{
    		semi=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected SEMICOLON Token");
    		return null;
    	} 
        if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_CURLY_B"))
    	{
    		rightCurlyB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected } Token");
    		return null;
    	} 
    	MethodDeclaration methDec=new MethodDeclaration(P, type1, ID1,
    			leftRoundB, type2, ID2, comma, type3, ID3, rightRoundB,
    			leftCurlyB, varDeclaration, statement, Return, expression, semi,
    			rightCurlyB);
    	return methDec;
    }
    private MainClass MainClassRule()
    {
    	//"”class” Identifier “{”  “public” “static” “void” “main” “(“ “String” “[” “]”Identifier “)” “{” Statement “}” “}”"
    	Token Class=null;
    	Token ID1 =null;
    	Token leftCurlyB1=null;
    	Token Public=null;
    	Token Static=null;
    	Token Void =null;
    	Token Main=null;
    	Token leftRoundB=null;
    	Token string;
    	Token leftSquareB=null;
    	Token rightSquareB=null;
    	Token ID2 =null;
    	Token rightRoundB=null;
    	Token leftCurlyB2=null;
    	Statement stat=null;
    	Token rightCurlyB1=null;
    	Token rightCurlyB2=null;
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("CLASS"))
    	{
    		Class=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected CLASS Token "+tokens.get(indexPointer).Type);
    		return null;
    	}
    	if ("ID".equals(tokens.get(indexPointer).Type)){
            ID1=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }

    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_CURLY_B"))
    	{
    		leftCurlyB1=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_CURLY_B token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("PUBLIC"))
    	{
    		Public=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected PUBLIC token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("STATIC"))
    	{
    		Static=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected STATIC token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("VOID"))
    	{
    		Void=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected VOID token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("MAIN"))
    	{
    		Main=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected MAIN token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_ROUND_B"))
    	{
    		leftRoundB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_ROUND_B token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("STRING"))
    	{
    		string=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected STRING token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_SQUARE_B"))
    	{
    		leftSquareB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_SQUARE_B token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_SQUARE_B"))
    	{
    		rightSquareB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_SQUARE_B token");
    		return null;
    	}
    	if ("ID".equals(tokens.get(indexPointer).Type)){
            ID2=tokens.get(indexPointer);
                indexPointer++;
        }
        else
        {
            System.out.println("Syntax error expected ( ");
            return null;  
        }

    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_ROUND_B"))
    	{
    		rightRoundB=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_ROUND_B token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("LEFT_CURLY_B"))
    	{
    		leftCurlyB2=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected LEFT_CURLY_B token");
    		return null;
    	}
    	stat=StatementRule();
    	if (stat==null)
    	{
    		System.out.println("Syntax error expected Statement object");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_CURLY_B"))
    	{
    		rightCurlyB1=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_CURLY_B token");
    		return null;
    	}
    	if ((tokens.size()>indexPointer)&&tokens.get(indexPointer).Type.equals("RIGHT_CURLY_B"))
    	{
    		rightCurlyB2=tokens.get(indexPointer);
    		indexPointer++;
    	}
    	else {
    		System.out.println("Syntax error expected RIGHT_CURLY_B token");
    		return null;
    	}
    	MainClass mainClass=new MainClass(Class,ID1, leftCurlyB1, Public,
    			Static, Void, Main, leftRoundB, string, leftSquareB, rightSquareB,
    			ID2, rightRoundB, leftCurlyB2, stat, rightCurlyB1, rightCurlyB2);
    	return mainClass;
    }
   
    
    
    //---------------------------------------------------------
    /*
    Statement ::= "{" ( Statement )* "}" |
 	"if" "(" Expression ")" Statement  Ifstm | 
 	"while" "(" Expression ")" Statement |
 	"System.out.println" "(" Expression ")" ";”|
 	Identifier  IdentifierExpr
IdentifierExpr ::= "=" Expression ";" | "[" Expression "]" "=" Expression ";"

Ifstm ::= ( "else" Statement ) ?

    *///Statement ::= "{" ( Statement )* "}" |
    private Statement StatementRule() 
    {
        if ("LEFT_CURLY_B".equals(tokens.get(indexPointer).Type)) {
            Token left_CURLY_B=tokens.get(indexPointer);
            indexPointer++;
            if("RIGHT_CURLY_B".equals(tokens.get(indexPointer).Type)){
                Token right_CURLY_B=tokens.get(indexPointer);
                indexPointer++;
                return new Statement_1(left_CURLY_B, null, right_CURLY_B);
                
            }else{
                ArrayList<Statement>stms= new ArrayList<>();
                Statement stm=null;
                while ((stm=StatementRule())!=null){
                    stms.add(stm);
                }
                
                if("RIGHT_CURLY_B".equals(tokens.get(indexPointer).Type)){
                    Token right_CURLY_B=tokens.get(indexPointer);
                    indexPointer++;
                    return new Statement_1(left_CURLY_B, stms, right_CURLY_B);
                }else {
                    System.out.println("Error: missing \"}\"");
                    return null;
                }
            }
        }//"if" "(" Expression ")" Statement  Ifstm | 
        else if ("IF".equals(tokens.get(indexPointer).Type))
        {
            Token _if=tokens.get(indexPointer);
            indexPointer++;
            if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type)) {
                Token left_round_B=tokens.get(indexPointer);
                indexPointer++;
                Expression expression=ExpressionRule();
                if(expression==null){
                    System.out.println("Error: expected exepression or boolean value");
                    return null;
                }else if("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type)){
                    Token right_round_B=tokens.get(indexPointer);
                    indexPointer++;
                    Statement stm=StatementRule();
                    if(stm==null)
                        System.out.println("Error: expected statement!");
                    else{
                        Ifstm ifstm=IfstmRule();
                        return new Statement_2(_if, left_round_B, expression, right_round_B, stm, ifstm);
                    }
                } else {
                    System.out.println("Syntax error: expected \")\"");
                    return null;
                }
            } else {
                System.out.println("Syntax error: expected \"(\"");
                return null;
            }
        }//"while" "(" Expression ")" Statement |
        else if ("WHILE".equals(tokens.get(indexPointer).Type))
        {
            Token _while=tokens.get(indexPointer);///////////////////
            indexPointer++;
            if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type)) {
                Token left_round_B=tokens.get(indexPointer);
                indexPointer++;
                Expression expression=ExpressionRule();
                if(expression==null){
                    System.out.println("Error: expected exepression or boolean value");
                    return null;
                }else if("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type)){
                    Token right_round_B=tokens.get(indexPointer);
                    indexPointer++;
                    Statement stm=StatementRule();
                    if(stm==null)
                        System.out.println("Error: expected statement!");
                    else{
                        return new Statement_3(_while, left_round_B, expression, right_round_B, stm);
                    }
                } else {
                    System.out.println("Syntax error: expected \")\"");
                    return null;
                }
            } else {
                System.out.println("Syntax error: expected \"(\"");
                return null;
            }
        }//"System.out.println" "(" Expression ")" ";”|
        else if ("SYSTEM.OUT.PRINTLN".equals(tokens.get(indexPointer).Type))
        {
            Token _println=tokens.get(indexPointer);
            indexPointer++;
            if ("LEFT_ROUND_B".equals(tokens.get(indexPointer).Type)) {
                Token left_round_B=tokens.get(indexPointer);
                indexPointer++;
                Expression expression=ExpressionRule();
                if(expression==null){
                    System.out.println("Error: expected exepression or boolean value");
                    return null;
                }
                else if("RIGHT_ROUND_B".equals(tokens.get(indexPointer).Type)){
                    Token right_round_B=tokens.get(indexPointer);
                    indexPointer++;
                    if("SEMICOLON".equals(tokens.get(indexPointer).Type)){
                        Token simicolon=tokens.get(indexPointer);
                        indexPointer++;
                        return new Statement_4(_println, left_round_B, expression, right_round_B, simicolon);
                    }else {
                        System.out.println("Syntax error: expected \";\"");
                        return null;
                    }
                }else {
                    System.out.println("Syntax error: expected \")\"");
                    return null;
                }
            }else {
                System.out.println("Syntax error: expected \"(\"");
                return null;
            }
        }//Identifier  IdentifierExpr
        else if ("ID".equals(tokens.get(indexPointer).Type))
        {
            Token id=tokens.get(indexPointer);
            indexPointer++;
            
            IdentifierExpr idexpression=identifierExpressionRule();
            if(idexpression==null){
                System.out.println("Syntax error: expected IdentifierExpr");
                return null;
            }else {
                return new Statement_5(id, idexpression);
            }
        }
        return null;
    }
//IdentifierExpr ::= "=" Expression ";" |
    //"[" Expression "]" "=" Expression ";"
    private IdentifierExpr identifierExpressionRule(){
        if ("EQUAL".equals(tokens.get(indexPointer).Type))
        {
            Token equals=tokens.get(indexPointer);
            indexPointer++;
            
            Expression expression=ExpressionRule();
            if(expression==null){
                System.out.println("Error: expected IdentifierExpr");
                return null;
            }else if("SEMICOLON".equals(tokens.get(indexPointer).Type)){
                Token simicolon=tokens.get(indexPointer);
                indexPointer++;
                return new IdentifierExpr_1(equals, expression, simicolon);
            }
        }//"[" Expression "]" "=" Expression ";"
        else if ("LEFT_SQUARE_B".equals(tokens.get(indexPointer).Type)) {
            Token left_square_B=tokens.get(indexPointer);
            indexPointer++;
            
            Expression expression=ExpressionRule();
            if(expression==null){
                System.out.println("Syntax error: expected Expression");
                return null;
            }else if("RIGHT_SQUARE_B".equals(tokens.get(indexPointer).Type)){
                Token right_square_B=tokens.get(indexPointer);
                indexPointer++;
                if ("EQUAL".equals(tokens.get(indexPointer).Type)){
                    Token equals=tokens.get(indexPointer);
                    indexPointer++;
                    if("SEMICOLON".equals(tokens.get(indexPointer).Type)){
                        Token simicolon=tokens.get(indexPointer);
                        indexPointer++;
                        return new IdentifierExpr_2(left_square_B, expression, right_square_B, equals, expression, simicolon);
                    }else {
                        System.out.println("Syntax error: expected \";\"");
                        return null;
                    }
                }else {
                    System.out.println("Syntax error: expected \"=\"");
                    return null;
                }
            }else {
                System.out.println("Syntax error: expected \"]\"");
                return null;
            }
        }
        return null;
    }
//Ifstm ::= ( "else" Statement ) ?
    private Ifstm IfstmRule(){
        if ("ELSE".equals(tokens.get(indexPointer).Type))
        {
            Token _else=tokens.get(indexPointer);
            indexPointer++;
            
            Statement statement=StatementRule();
            if(statement==null){
                System.out.println("Error: expected statement");
                return null;
            }else 
                return new Ifstm(_else, statement);
            
        }
        return null;
    }
    
}
