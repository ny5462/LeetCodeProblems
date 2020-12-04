/** program to remove outer parentheses from a string s,
done using a counter which adds when "(" is seen and deducts vice versa,
this prevents outermost brackets to be appended to string 
TC-O(N)
**/
class Solution {
    public String removeOuterParentheses(String S) {
        char[] str= S.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<str.length;i++){
            if(str[i]=='('){
                ++count;
            if(count!=1)sb.append(str[i]);
            }if(str[i]==')'){
                --count;
                if(count!=0)sb.append(str[i]);
            }
        }
        return sb.toString();
        
    }
}
