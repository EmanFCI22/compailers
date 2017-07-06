package Parser;

import Lexical.Token;
/*
 * MainClass : := ”class” Identifier “{”  “public” “static” “void” “main” “(“ “String” “[” “]”Identifier “)” “{” Statement “}” “}”
 * */
public class MainClass implements Node{

	Token Class;
	Token ID1 ;
	Token leftCurlyB1;
	Token Public;
	Token Static;
	Token Void ;
	Token Main;
	Token leftRoundB;
	Token string;
	Token leftSquareB;
	Token rightSquareB;
	Token ID2 ;
	Token rightRoundB;
	Token leftCurlyB2;
	Statement stat;
	Token rightCurlyB1;
	Token rightCurlyB2;
	

	public MainClass(Token class1, Token ID1, Token leftCurlyB1,
			Token public1, Token static1, Token void1, Token main,
			Token leftRoundB, Token string, Token leftSquareB,
			Token rightSquareB, Token ID2, Token rightRoundB,
			Token leftCurlyB2, Statement stat, Token rightCurlyB1,
			Token rightCurlyB2) {
		Class = class1;
		this.ID1 = ID1;
		this.leftCurlyB1 = leftCurlyB1;
		Public = public1;
		Static = static1;
		Void = void1;
		Main = main;
		this.leftRoundB = leftRoundB;
		this.string = string;
		this.leftSquareB = leftSquareB;
		this.rightSquareB = rightSquareB;
		this.ID2 = ID2;
		this.rightRoundB = rightRoundB;
		this.leftCurlyB2 = leftCurlyB2;
		this.stat = stat;
		this.rightCurlyB1 = rightCurlyB1;
		this.rightCurlyB2 = rightCurlyB2;
	}


	public void printNode() {
		// TODO Auto-generated method stub
		System.out.print(Class.value+" "+ID1.value+" "+leftCurlyB1.value+" "+Public.value+" "+Static.value+ " "+Void.value
				+" "+Main.value+" "+leftRoundB.value+" "+string.value+leftSquareB.value+
				rightSquareB.value+" "+ID2.value+" ");
		System.out.print(rightRoundB.value+leftCurlyB2.value+" ");
		stat.printNode();
		System.out.print(rightCurlyB1.value+" "+rightCurlyB2.value+" ");
		
	}
	

}
