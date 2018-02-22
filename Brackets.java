
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Brackets{
	
public static void main(String args[]) throws IOException{
		
		findBracketBalance(args);
		
	}

public static Map<String, Integer> bracketCount = new HashMap<String, Integer>(); 
public static List <Integer> openBrackets = new ArrayList <Integer>();
public static List <Integer> closedBrackets = new ArrayList <Integer>();
private int _lineNumber;





public static boolean findBracketBalance(String args[]) throws IOException {

	BufferedReader br = new BufferedReader(new FileReader("br.js"));
	String eachLine = "";
	int lineNumber = 0;
	boolean balanced = true;
	Stack <Character> stack = new Stack <Character> ();
	
	try{
		while((eachLine = br.readLine()) != null){
			lineNumber += 1;
			 
			for (int i = 0; i < eachLine.length(); i++){
		        char current = eachLine.charAt(i);
		        if (current == '{'){
		            stack.push(current);
		            openBrackets.add(lineNumber);
		            continue;
		        }

		        if (current == '}'){
		        	closedBrackets.add(lineNumber);
		            if (stack.isEmpty()){
		            	System.out.println("Found extra '}' at line " + lineNumber);
		            	balanced = false;
		            	continue;
		            }

		            char last = stack.peek();	
		            if (current == '}' && last == '{'){
		                stack.pop();
		                openBrackets.remove(openBrackets.size() - 1);
		                continue;
		            }
		        }
		    }
		}
		Iterator<Integer> iterator = openBrackets.iterator();
		while (!stack.isEmpty()){
			System.out.println("Missing closing bracket corresponding to '{' at line " + iterator.next());
			stack.pop();
			balanced = false;
        }
		
	}
	finally{
		br.close();
	}
	if (balanced) return stack.isEmpty(); 
	else
		return false;
}
	
}