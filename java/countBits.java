/** program to return an array with bitcount of all nos upto and including n.
Done using DP.
Credits- https://leetcode.com/problems/counting-bits/discuss/345138/Java-DP-solution-beats-99.71
TC-O(N)
**/
class Solution {
    public int[] countBits(int num) {
        int [] arr=new int[num+1];
        arr[0]=0;
        if(num==0)return arr;
        arr[1]=1;
        for(int i=2;i<=num;i++){
            arr[i]=arr[i/2]+i%2;
        }
        return arr;
}
}
