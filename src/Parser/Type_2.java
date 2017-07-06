package Parser;

import Lexical.Token;

public class Type_2 extends Type{
	Token Boolean;
	Type2 type;
	
	public Type_2(Token Boolean, Type2 type) {
		this.Boolean= Boolean;
		this.type = type;
	}

	@Override
	public void printNode() {
		System.out.print(Boolean.value+" ");
		if (type !=null)
			type.printNode();
		
	}


}
