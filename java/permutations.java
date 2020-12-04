/** write all permutations of a given array. Done using backtracking, or dfs, by using a temp list, and for every iteration we iterate entire array, if that element is not inside the temp list, we add it, and recurse again, after returning from dfs to parent node of recursion, we remove the last element added after a successful recursion. we end the recursion or set the base case, when the temp list size equals length of array, we clone the elements of that list and add it to the answer.
TC-O(N*N!)
**/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans,list,nums);
        return ans;
        
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> list, int[] nums){
        if(list.size()==nums.length)ans.add(new ArrayList<>(list));
        else{
            for(int i=0;i<nums.length;i++){
                if(list.contains(nums[i]))continue;
                list.add(nums[i]);
                dfs(ans,list,nums);
                list.remove(list.size()-1);
            }
        }
    }
    
    
}
