package Parser;

import java.util.ArrayList;

import Lexical.Token;


public class Goal implements Node{

	MainClass mainClass ;
	ArrayList<ClassDeclaration> classDeclaration;
	Token endFile;
	public Goal(MainClass mainClass,ArrayList<ClassDeclaration> classDeclaration,Token endFile)
	{
		this.mainClass=mainClass;
		this.classDeclaration=classDeclaration;
		this.endFile=endFile;
	}
	public void printNode() {
		// TODO Auto-generated method stub
		
		if (mainClass!=null)
			mainClass.printNode();
		if (classDeclaration!=null)
		{
			for (int i=0;i<classDeclaration.size();i++)
			{
				classDeclaration.get(i).printNode();
			}
		}
		System.out.print(endFile.value+" ");
	}

	
}
