/** You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
Done using DP by first sorting according to first element.
TC-O(n^2)
**/
class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] S=new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        for(int i=0;i<pairs.length;i++){
            S[i]=1;
            for(int j=i-1;j>=0;j--){
                if(pairs[i][0]>pairs[j][1]){
                    S[i]=Math.max(S[i-1],1+S[j]);
                    break;
                }
            }
        }
        return S[S.length-1];
    }
}
