/** segment a given string to a list of given words, return if possible, done using dp, where you iterate over substrings, and store if a substring is found starting from current index int o a boolean array.
TC-O(n^2)
credits- https://leetcode.com/problems/word-break/discuss/43987/Easy-to-understand-2ms-java-solution-using-dp
**/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp=new boolean[s.length()+1];
        int n=s.length();
        dp[n]=true;
        HashSet<String> set=new HashSet<>(wordDict);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                if(dp[j]&&set.contains(s.substring(i,j))){
                    dp[i]=true;
                    break;
                }
            }
        }return dp[0];
    }
}
