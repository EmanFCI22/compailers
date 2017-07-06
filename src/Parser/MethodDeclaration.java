package Parser;
import java.util.ArrayList;

import Lexical.*;
/*MethodDeclaration : := ( “public” | “private” ) Type Identifier “(” (Type Identifier ( “,”Type Identifier ) ? “)” “{” (VarDeclaration ) * (Statement ) * “return” Expression “;” “}”*/
public class MethodDeclaration implements Node{

	Token P;
	Type type1;
	Token ID1;
	Token leftRoundB;
	Type type2;
	Token ID2;
	Token comma; 
	Type type3;
	Token ID3;
	Token rightRoundB;
	Token leftCurlyB;
	ArrayList<VarDeclaration> varDeclaration;
	ArrayList<Statement> statement;
	Token Return;
	Expression expression;
	Token semi;
	Token rightCurlyB;
	
	public MethodDeclaration(Token p, Type type1, Token ID1,
			Token leftRoundB, Type type2, Token ID2, Token comma,
			Type type3, Token ID3, Token rightRoundB,
			Token leftCurlyB, ArrayList<VarDeclaration> varDeclaration,
			ArrayList<Statement> statement, Token return1,
			Expression expression, Token semi, Token rightCurlyB) {
		super();
		P = p;
		this.type1 = type1;
		this.ID1 = ID1;
		this.leftRoundB = leftRoundB;
		this.type2 = type2;
		this.ID2 = ID2;
		this.comma = comma;
		this.type3 = type3;
		this.ID3 = ID3;
		this.rightRoundB = rightRoundB;
		this.leftCurlyB = leftCurlyB;
		this.varDeclaration = varDeclaration;
		this.statement = statement;
		Return = return1;
		this.expression = expression;
		this.semi = semi;
		this.rightCurlyB = rightCurlyB;
	}

	@Override
	public void printNode() {
		System.out.print(P.value+" ");
		type1.printNode();
		
		System.out.print(ID1.value+
                        " "+leftRoundB.value+" ");
		type2.printNode();
		System.out.print(ID2.value+" ");
		if (comma!=null)
		{
			System.out.print(comma.value+" ");
			type3.printNode();
			System.out.print(ID3.value+" ");
		}
		System.out.print(rightRoundB.value+" "+leftCurlyB.value+" ");
		for(int i=0;i<varDeclaration.size();i++)
			varDeclaration.get(i).printNode();
		for(int i=0;i<statement.size();i++)
			statement.get(i).printNode();
		System.out.print(Return.value+" ");
		expression.printNode();
		System.out.print(semi.value+" "+rightCurlyB.value+" ");
		
	}

}
