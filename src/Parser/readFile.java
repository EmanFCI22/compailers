package Parser;
import Lexical.Token;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class readFile 
{
    public static ArrayList<Token> ReadFile(String FileName) throws IOException
    {
            ArrayList<Token> tokens =new ArrayList<Token>();
           
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            try {
                String arr [];
                String line = br.readLine();
                while (line != null) {
                     Token tmp = new Token("","");
                    arr=line.split(" ");
                    tmp.Type=arr[1];
                    if(tmp.Type.equals("EOL")){
                        br.readLine();
                    }
                    else  if (arr[4].length()>3&&arr[4].substring(1,3).equals("/*"))
                    {
                    	String tmp2;
                    	 tmp2=arr[4];
                         for (int i=5;i<arr.length;i++)
                                 tmp2+=" "+arr[i];
                    	while (true){
                    	if (tmp2.length()> 4&& tmp2.substring(tmp.value.length()-3 , tmp2.length()-1).equals("*/"))
                    		break;
                    	tmp2+=br.readLine();
                    	}
                    	System.out.println("++++++++++++++++"+tmp2);
                    }else{
                        tmp.value=arr[4];
                        for (int i=5;i<arr.length;i++)
                                tmp.value=tmp.value+" "+arr[i];
                        tmp.value=tmp.value.substring(1, tmp.value.length()-1);
                        tokens.add(tmp);
                    }
                    
                   
                    System.out.println(tmp.Type+" "+tmp.value);
                    line = br.readLine();
                }
            } finally {
                br.close();
            }

            return tokens;
    }
    
}
