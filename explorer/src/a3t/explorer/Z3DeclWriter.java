package a3t.explorer;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Z3DeclWriter
{
	private static final Pattern varNamePat = Pattern.compile("\\$[^ \\)]+( |\\))");

	private PrintWriter pcDeclWriter;
	private Set<String> varNames = new HashSet();

	Z3DeclWriter(File file)
	{
		try{
			pcDeclWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		}catch(IOException e){
			throw new Error(e);
		}
	}

	void process(String pc)
	{
		//find the vars
		Matcher matcher = varNamePat.matcher(pc);
		while(matcher.find()){
			String varName = matcher.group();
			varName = varName.substring(0, varName.length()-1);
			if(varNames.contains(varName))
				continue;
			varNames.add(varName);

			char ch = varName.charAt(0);
			assert ch == '$';
		
			boolean array = false;
			int i = 1;
			ch = varName.charAt(i);
			if(ch == '!'){
				array = true;
				i++;
			}
			String type = null;
			char typeCode = varName.charAt(i);
			switch(typeCode){
			case 'I':
			case 'B':
			case 'S':
			case 'C':
			case 'L':			
				type = "Int";
      		break;
			case 'F':
			case 'D':
				type = "Real";
		    break;
			default:
				throw new RuntimeException(varName);
			}
			
			if(array){
				type = "(Array Int " + type + ")";
			}
			
			String decl = "(declare-const " + varName + " " + type + ")";	
			pcDeclWriter.println(decl);	
		}
	}

	private void addConstraintsAtLeast38()
	{
		for(String varName : varNames){
			if(varName.startsWith("$!F$deliverPointerEvent$android$view$MotionEvent$0$")){
				String constr = "(assert (>= (select " + varName + " 1) 39.0))";
				pcDeclWriter.println(constr);
			}
		}
	}

	private void addToIntDecl()
	{
		pcDeclWriter.println("(define-fun my_to_int ((x Real)) Int (if (>= x 0.0) (to_int x) (- (to_int (- x)))))");
	}
	
	void finish()
	{
		addToIntDecl();
		addConstraintsAtLeast38();
		pcDeclWriter.close();
	}
}