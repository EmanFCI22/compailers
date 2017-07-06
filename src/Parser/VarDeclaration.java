package Parser;
import Lexical.*;
/*VarDeclaration : := Type Identifier “;”*/
public class VarDeclaration implements Node{

	Type type;
	Token ID;
	Token semi;
	
	public VarDeclaration(Type type, Token ID, Token semi) {
		super();
		this.type = type;
		this.ID = ID;
		this.semi = semi;
	}

	@Override
	public void printNode() {
		type.printNode();
		System.out.print(ID.value+" "+semi.value+" ");		
	}

}
