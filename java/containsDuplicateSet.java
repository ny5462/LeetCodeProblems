/** program to check if array contains duplicate elements, if yes, return true.
Done Using HashSet. TC-O(N)
**/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num))return true;
            else set.add(num);
        }
        return false;
    }
}
