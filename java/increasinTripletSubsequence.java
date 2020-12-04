/** program to find whether an increasing triplet subsequence exists or not. i.e  3 elements which are increasing in values and index. Done using DP for longest increasing subsequence, can be done in O(n) and O(1) using greedy algorithm. Dp approach below.
O(n^2)
**/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        int[]S=new int[nums.length];  
        int max=0;
        
        for(int j=0;j<nums.length;j++){
            S[j]=1;
            for(int k=0;k<=j-1;k++){
                if(nums[k]<nums[j] &&S[j]<S[k]+1){
                    S[j]=S[k]+1;
                    if(S[j]>max){
                        max=S[j];
                        if(max==3)return true;
                }
            }
           // System.out.println(S[j]);
        }
    }
        return false;
}
}
/** greedy approach by maintaining two variables and manipulating them as you move
credits -https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/discuss/595914/Java-Simple-Solution**/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        int first=Integer.MAX_VALUE;
        int second= Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(first==Integer.MAX_VALUE||nums[i]<=first){
                first=nums[i];
            }
            else if(first<nums[i]){
                if(second==Integer.MAX_VALUE||nums[i]<=second){
                second=nums[i];
                }
                else if(nums[i]>second){
                    return true;
                }
            }
        
        }
        return false;
    }
}
