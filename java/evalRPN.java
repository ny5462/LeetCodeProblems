/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Done by using stack and push numbers to it, once we encounter an operand, we pop and store last 2 elements , calculate their operation and push it back on the stack.
final result would be stored on top of the stack.
it is important to note that operation would be carried out in manner num2 (operand) num1 , as it may cause issues in division and subtraction.
TC-O(N)
**/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        
        for(String token :tokens){
            
            if(!"+-*/".contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }
            
            int num1=stack.pop();
            int num2= stack.pop();
            
            switch(token){
                case "+":
                    num1=num1+num2;
                    break;
                case "-":
                    num1=num2-num1;
                    break;
                case "*":
                    num1=num1*num2;
                    break;
                case "/":
                    num1=num2/num1;
                    break;
            }
            stack.push(num1);
        }
        return stack.pop();
    }
}

