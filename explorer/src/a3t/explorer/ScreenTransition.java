package a3t.explorer;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class ScreenTransition
{
	/*
	private static final String SYMBOL = "\\$\\!F\\$deliverPointerEvent\\$android\\$view\\$MotionEvent\\$0\\$";
	
	static int check(int id)
	{
		String script = AnExecution.SCRIPT_TXT+"."+id;
		
		if(match(0, script, "dummy1"))
			return 0; //stays in the same screen
		
		if(match(1, script, "dummy2"))
			return -1; //returns
		else
			return 1; //calls
	}
	
	private static boolean match(int offset, String script, String prefix)
	{
		String dummyScript = prefix+script;
		int eventCount = createScript(script, dummyScript, offset);
		
		if(offset >= eventCount)
			return false;

		String toReplace = SYMBOL+((eventCount-1-offset)*2)+" ";
		String toReplaceWith = SYMBOL+(eventCount*2)+" ";

		Path dummyPath = new Path(Main.newOutFile(dummyScript), true);
		dummyPath.execute();

		int[] pcIndices = findIndicesToMatch(offset, eventCount, dummyPath.id());
		int startLine1 = pcIndices[0];
		int endLine1 = pcIndices[1];
		int startLine2 = pcIndices[2];
		
		BufferedReader reader1 = reader(startLine1, dummyPath.id());
		BufferedReader reader2 = reader(startLine2, dummyPath.id());
		
		assert reader1 != null;
		assert reader2 != null;
		
		String line1 = null, line2 = null;
		try{
			while((line1 = reader1.readLine()) != null){
				line2 = reader2.readLine();
				if(line2 == null)
					return false;
				line1 = line1.replaceAll(toReplace, toReplaceWith);
				if(!line1.equals(line2)){
					//System.out.println("line1: " + line1 + "\nline2: " + line2);
					return false;
				}
				startLine1++;
				if(startLine1 == endLine1){
					if(reader2.readLine() != null)
						return false;
					else
						return true;
				}
			}
		}catch(IOException e){
			throw new Error(e);
		}
		throw new RuntimeException(line1 + " " + line2 + " " + startLine1 + " " + startLine2);
	}

	static BufferedReader reader(int index, int id)
	{
		try{
			BufferedReader reader = Main.newReader(Path.pcFileNameFor(id));
			String line;
			int count = 0;
			while(count < index && (line = reader.readLine()) != null){
				if(!line.startsWith("*")){
					count++;
				}
			}
			if(count == index)
				return reader;
			reader.close();
			assert false : "count = " + count + " index = " + index;
			return null;
		}catch(IOException e){
			throw new Error(e);
		}
	}

	static int[] findIndicesToMatch(int offset, int eventCount, int id)
	{
		try{
			int k = eventCount - offset;
			int[] result = new int[3];
			result[0] = 0;
			int i = 0;
			BufferedReader reader = Main.newReader(Path.traceFileNameFor(id));
			String line;
			int count = 0;
			while((line = reader.readLine()) != null){
				if(line.equals("")){
					count++;
					if(count == (eventCount - offset)){
						result[1] = result[0];
						i = 1;
					}
					else if(count == k+1){
						i = 2;
						result[2] = result[1];
					}
					if(count == eventCount+1)
						break;
				}
				else{
					result[i]++;
				}
				//System.out.println(line + " " + count);
			}
			assert count == eventCount+1 : "eventCount = " + eventCount + " count == " + count;
			reader.close();
			return result;
		}catch(IOException e){
			throw new Error(e);
		}
		
	}

	static int createScript(String script, String dummyScript, int offset)
	{
		assert offset == 0 || offset == 1;
		int eventCount = 0;
		try{
			BufferedReader reader = Main.newReader(script);
			PrintWriter writer = Main.newWriter(dummyScript);
			String line, lastLine = null, lastButOne = null;
			while((line = reader.readLine()) != null){
				eventCount++;
				lastButOne = lastLine;
				lastLine = line;
				writer.println(line);
			}
			String s = offset == 0 ? lastLine : lastButOne;
			writer.println(s);
			reader.close();
			writer.close();
		}catch(IOException e){
			throw new Error(e);
		}
		return eventCount;
	}
	*/
}