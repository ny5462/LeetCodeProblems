/** program to represent a baseball game where 
Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
TC-O(N)
used a stack to add score of each round, and then traversed through stack adding up points
soln derived from - https://leetcode.com/problems/baseball-game/
**/
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        for(String op: ops){
            if(op.equals("+")){
                int top=stack.pop();
                int newtop=top+stack.peek();
                stack.push(top);
                stack.push(newtop);
            }else if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(2*stack.peek());
            }else{
                stack.push(Integer.valueOf(op));
            }
        }
        int score=0;
        for(int val:stack)score+=val;
        return score;
        
    }
}
