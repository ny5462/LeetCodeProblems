/** program to return minimum no of valid brackets to be added to make the expression valid.
i.e expression of "((())((".DOne using stack and counter, where everytime a valid match is found it is popped out.
TC-O(N)
**/
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack=new Stack<>();
        int counter=S.length();
        for(int i=0;i<S.length();i++){
            if(stack.isEmpty()){
                stack.push(S.charAt(i));
            }else if(stack.peek()=='('&&S.charAt(i)==')'){
                stack.pop();
                counter-=2;
        }else{
                stack.push(S.charAt(i));
            }
    }
        return counter;
}
}
