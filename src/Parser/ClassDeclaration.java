package Parser;

import java.util.ArrayList;

import Lexical.*;
/*ClassDeclaration : := “class” Identifier ( “extends” Identifier  ) ? “{” ( VarDeclaration ) * ( MethodDeclaration ) * “}*/
public class ClassDeclaration implements Node{


	Token Class ;
	Token ID1;
	Token extend;
	Token ID2;
	Token leftCurlyB;
	ArrayList<VarDeclaration> varDeclaration;
	ArrayList<MethodDeclaration> methodDeclaration;
	Token rightCurlyB;
	
	
	
	public ClassDeclaration(Token class1, Token ID1, Token extend,
			Token ID2, Token leftCurlyB,
			ArrayList<VarDeclaration> varDeclaration,
			ArrayList<MethodDeclaration> methodDeclaration, Token rightCurlyB) {
		super();
		Class = class1;
		this.ID1 = ID1;
		this.extend = extend;
		this.ID2 = ID2;
		this.leftCurlyB = leftCurlyB;
		this.varDeclaration = varDeclaration;
		this.methodDeclaration = methodDeclaration;
		this.rightCurlyB = rightCurlyB;
	}



	public void printNode() {
		System.out.print(Class.value+" "+ID1.value+" ");
		
		if (extend!=null){
			System.out.print(extend.value+" "+ID2.value+" ");
			
		}
		System.out.print(leftCurlyB.value+" ");
		for (int i=0;i<varDeclaration.size();i++)
			varDeclaration.get(i).printNode();
		for (int i=0;i<methodDeclaration.size();i++)
			methodDeclaration.get(i).printNode();
		System.out.print(rightCurlyB.value+" ");
		
	}

}
