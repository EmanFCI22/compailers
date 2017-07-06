package Parser;

import Lexical.Token;

public class Type2 implements Node{

	Token leftSquareB;
	Token rightSquareB;
	
	
	public Type2(Token leftSquareB, Token rightSquareB) {
		this.leftSquareB = leftSquareB;
		this.rightSquareB = rightSquareB;
	}


	@Override
	public void printNode() {
		if (leftSquareB!=null)
		{
			System.out.print(leftSquareB.value+" "+rightSquareB.value+" ");
		}
		
	}

}
