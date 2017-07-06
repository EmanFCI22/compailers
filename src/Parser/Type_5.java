package Parser;

import Lexical.Token;

public class Type_5 extends Type{
	Token Char;
	Type2 type;
	
	public Type_5(Token Char, Type2 type) {
		this.Char= Char;
		this.type = type;
	}

	@Override
	public void printNode() {
		System.out.print(Char.value+" ");
		if (type !=null)
			type.printNode();
		
	}


}
