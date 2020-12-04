/** find unique triplets that sum up to zero in the array, and store those triplets in 
a list . TC-O(n^3)
**/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target; 
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
            List<Integer> check= new ArrayList<>();
                for (int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        check.add(nums[i]);check.add(nums[j]);check.add(nums[k]);
                        list.add(check);        
                    }
                }
            }
        }
        return list;
    }
}

/**O(n^2)
credits-https://leetcode.com/problems/3sum/discuss/431685/Java-Solution-Using-ArrayList
**/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        if(nums.length<3)return ans;
        
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                 if(sum>0){
                    k--;
                }
                else  if(sum<0){
                    j++;
                }
                else{
                    List<Integer> tri=new ArrayList<>();
                    tri.add(nums[i]);
                    tri.add(nums[j]);
                    tri.add(nums[k]);
                    if(!set.contains(tri)){
                        ans.add(tri);
                        set.add(tri);
                    }
                    j++;
                    k--;
                }
            }
           
        }
        return ans;
    }   
}
