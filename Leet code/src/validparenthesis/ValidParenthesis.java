package validparenthesis;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* @author GarganGerard - 40061139
*/
public class ValidParenthesis {

	public static void main(String[] args) {
		boolean valid = isValid("([)]");
		System.out.println(valid);

	}
	
	
	    public static boolean isValid(String s) {

	        Queue<Character> letters = new LinkedList<Character>();

	        for(int i=0; i<s.length(); i++){
	            char c = s.charAt(i);
	            //check if its an opening bracket
	            if(c=='(' || c=='[' || c=='{'){
	                //add it to the queue
	                letters.add(c);

	            } else { //its a closing bracket
	                //check if queue is empty, if so there is no corresponding  opening bracket
	                if(letters.size()==0){
	                    return false; //string is not valid
	                }

	                char top = letters.peek(); //get the top element from the stack
	                //check if the current closing bracket matches the top opening bracket
	                if((c==')' && top=='(') || (c==']' && top=='[') || (c=='}' && top =='{')){
	                  letters.poll();
	                } else {
	                    return false;
	                }
	                
	            }
	        }
	        

	        return letters.isEmpty();
	    }
	}


