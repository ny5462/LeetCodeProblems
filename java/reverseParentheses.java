/**You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

Example 1:

Input: s = "(abcd)"
Output: "dcba"
done by using stringBuilder, reversing strings between parenthesis and replacing them in the stringbuilder. All operations carried out on stringbuilder being faster than being carried on string
TC-O(N^2)
**/
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb= new StringBuilder(s);
        while(sb.indexOf("(")!=-1){
            int start=sb.lastIndexOf("(");
            int end =sb.indexOf(")",start);
             
            sb.replace(start,end+1,new StringBuilder(sb.substring(start+1,end)).reverse().toString());
            //System.out.println(s);
        }
        return sb.toString();
    }
 }

