/** program to find nearbyDuplicates, that is if any two nearest duplicate numbers are less than a
specified number, return true.
Done using HashMap, where latest index is stored as values, and the number itself as key, and the
difference is checked at every iteration.
TC-O(N)
**/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int temp=map.get(nums[i]);
                if((i-temp)<=k)return true;
                else map.put(nums[i],i);
            }else{
                map.put(nums[i],i);
            }
        }return false;
        
    }
}
