/**
This program uses a stack to check if an expression is valid 
, it uses a hashmap to store corresponding pairs of brackets,
uses a stack to check if the corresponding opening pair exist 
for a read closed bracket. If not , it yields an invalid result
TC-O(n)
**/
import java.util.HashMap;
import java.util.Stack;

    
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
	// iterates through string each char at a time
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
	    // if closed bracket is read, checks if stack is empty or the pop yields its corresponding opening pair, if it doesn't yields invalid expression
            if(map.containsKey(c)){
                if(stack.empty()||stack.pop()!=map.get(c)) return false;
                
            }
	    // if it doesn't yield invalid expression , it pushes element on stack
            else{
                stack.push(c);
            }
        }
        return stack.empty();
           
    }
}
