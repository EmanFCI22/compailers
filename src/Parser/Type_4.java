package Parser;

import Lexical.Token;

public class Type_4 extends Type{
	Token Int;
	Type2 type;
	
	public Type_4(Token Int, Type2 type) {
		this.Int= Int;
		this.type = type;
	}

	@Override
	public void printNode() {
		System.out.print(Int.value+" ");
		if (type !=null)
			type.printNode();
		
	}


}
