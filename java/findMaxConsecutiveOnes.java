/** program to find max consecutive ones in a binary array, done by keep two variables count and maxcount. When 0 is read, count is reset, and after every 1 that is read, count is incremented, and if greater than maxcount, count is set to maxCount.
TC-O(N)
**/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int i:nums){
            if(i==1){
                count++;
                if(count>maxCount)maxCount=count;
            }if(i==0){
                count=0;
            }
        }
        return maxCount;
    }
}
