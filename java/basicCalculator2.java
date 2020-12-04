/**Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
Done using stack with if else statements, if characters read are numbers it is stored in a variable, if character is an operand , value stored in num is operated with value on top of stack and stored back in stack, according to previous seen sign, and sign is refreshed to current operand , and num is reset to zero. Therefore everytime you see an operand, perform previous operation between top of stack and value in num, and refresh last seen operand and num . Finally read all elements in stack and add them.
TC-O(N)
credits- https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
**/

class Solution {
    public int calculate(String s) {
     int num=0;
     char sign='+';        
     Stack<Integer> stack=new Stack<>();
     int len=s.length();
        
     for(int i=0;i<len;i++){
         char c=s.charAt(i);
         if(Character.isDigit(c)){
             num=num*10+(c-'0');
         }
         if((!Character.isDigit(c) && ' '!=c) || i==len-1){
             if(sign=='+'){
                 stack.push(num);
             }else if(sign=='-'){
                 stack.push(-num);
             }else if(sign=='*'){
                 stack.push(stack.pop()*num);
             }else if(sign=='/'){
                 stack.push(stack.pop()/num);
             }
             sign=c;
             num=0;
         }
     }
     int ans=0;
     for(int i:stack){
         ans+=i;
     }
        return ans;
    }
}
