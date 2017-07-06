package Parser;

import Lexical.Token;

public class Type_3 extends Type{
	Token Float;
	Type2 type;
	
	public Type_3(Token Float, Type2 type) {
		this.Float= Float;
		this.type = type;
	}

	@Override
	public void printNode() {
		System.out.print(Float.value+" ");
		if (type !=null)
			type.printNode();
		
	}


}
