/**A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Done using dynamic programming 


    If the string s is empty or null we return the result as 0.

    Initialize dp array. dp[0] = 1 to provide the baton to be passed.

    If the first character of the string is zero then no decode is possible hence initialize dp[1] to 0, otherwise the first character is valid to pass on the baton, dp[1] = 1.

    Iterate the dp array starting at index 2. The index i of dp is the i-th character of the string s, that is character at index i-1 of s.

    We check if valid single digit decode is possible. This just means the character at index s[i-1] is non-zero. Since we do not have a decoding for zero. If the valid single digit decoding is possible then we add dp[i-1] to dp[i]. Since all the ways up to (i-1)-th character now lead up to i-th character too.

    We check if valid two digit decode is possible. This means the substring s[i-2]s[i-1] is between 10 to 26. If the valid two digit decoding is possible then we add dp[i-2] to dp[i].

    Once we reach the end of the dp array we would have the number of ways of decoding string s.
    
credits- https://leetcode.com/problems/decode-ways/solution/
TC-O(N)
**/
class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)return 0;
        int[]dp=new int[s.length()+1];
        dp[0]=1;
        // adding 1 if string doesn't start with 0 indicating a valid first character.
        dp[1]=s.charAt(0)=='0'?0:1;
        for(int i=2;i<dp.length;i++){
            // if previous character is not zero we can take values from previous char as its a valid path
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            // if valid previous two char, even this can be a valid path
            int two=Integer.valueOf(s.substring(i-2,i));
            if(two>=10&&two<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }       
        
    }


