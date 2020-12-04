/** Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

 Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

Done by using a stack to keep track of parenthesis, a list to keep track of indices of opening paranthesis which is removed when a matching clsoes paranthesis is found, a set to keep track of all extra paranthesis.
TC- O(N)
2 passes
**/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set=new HashSet<>();
        Stack<Character> stack= new Stack<>();
        List<Integer> other=new ArrayList<>();        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                if(stack.isEmpty()||stack.peek()==')'){
                    set.add(i);
                }
                else if(stack.peek()=='('){
                    stack.pop();
                    other.remove(other.size()-1);
                }
            }
            else if(c=='('){
                stack.push('(');
                other.add(i);
            }
            else{
                continue;
            }
        }
        for(int i:other){
            set.add(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }return sb.toString();
    }
}
