/** program to check if two strings are equal where # characters equals backspace
O(Max(M,N))
**/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s=new Stack<>();
        Stack<Character> t=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(s.empty()){continue;}
                else s.pop();
            }else{
                s.push(S.charAt(i));
            }
        }
         for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'){
                if(t.empty()){continue;}
                else t.pop();
            }else{
                t.push(T.charAt(i));
            }
        }
        if(s.equals(t))return true;
        else return false;
    }
}
