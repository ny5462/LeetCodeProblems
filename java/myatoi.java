/**Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Done using trimming string and reading the characters
TC-O(N)

credits- https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3009/discuss/4710/My-Nice-Java-Code-3ms
**/

class Solution {
        
    public int myAtoi(String str) {
        if(str.length()==0||str.isEmpty())return 0;
        str=str.trim();
        char[] chars=str.toCharArray();
        if(str.length()==0||str.charAt(0)==' ')return 0;
        int head=0;
        int sign=1;
        if(chars[head]=='-'||chars[head]=='+'){
            if(chars[head]=='-')sign=-1;
            head++;
        }
        
        long result=0l;
        long max=(long)Integer.MAX_VALUE;
        long min=(long)Integer.MIN_VALUE;
        while(head<chars.length&&Character.isDigit(chars[head])){
            result=result*10+(((int)chars[head++]-'0')*sign);
            if(result>0&&result>max){
                result=max;
                break;
            }
            if(result<0&&result<min){
                result=min;
                break;
            }       
        }
        return (int)result;
        
     }
}
