/**
My Brute Force Solution O(n^2)
**/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int value;
        int [] result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=1+i;j<nums.length;j++){
                value=nums[i]+nums[j];
                if(value==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
}

/**
Ideal Solution O(n) 
**/
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }

}
}


