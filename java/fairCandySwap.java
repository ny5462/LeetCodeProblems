/** program to return array of answer where Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
Approach 1 done using brute force, by traversing every combination.
TC-O(N^2)
**/
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0,sumB=0;
        for(int i:A){
            sumA+=i;
        }
        for(int i:B){
            sumB+=i;
        }
        int[] ans=new int[2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(sumA-A[i]+B[j]==sumB-B[j]+A[i]){
                    ans[0]=A[i];
                    ans[1]=B[j];
                    return ans;
                }
                
            }
        }
        return ans;
    }
}

/** approach 2 done using hashset , and finding the delta difference element in hashset.
TC-O(N)
credit-https://leetcode.com/problems/fair-candy-swap/solution/
**/
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0,sumB=0;
        HashSet<Integer> set= new HashSet<>();
        for(int i:A){
            sumA+=i;
        }
        for(int i:B){
            sumB+=i;
        }
        int diff=(sumB-sumA)/2;
        for(int i:B)set.add(i);
        for(int i:A){
            if(set.contains(i+diff)){
                return new int[]{i,i+diff};
            }
        }
        
        
        throw null;
    }
}
