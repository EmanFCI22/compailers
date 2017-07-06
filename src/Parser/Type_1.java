package Parser;

import Lexical.Token;

public class Type_1 extends Type{
	Token string;
	Type2 type;
	
	public Type_1(Token string, Type2 type) {
		this.string= string;
		this.type = type;
	}

	@Override
	public void printNode() {
		System.out.print(string.value+" ");
		if (type !=null)
			type.printNode();
		
	}


}
