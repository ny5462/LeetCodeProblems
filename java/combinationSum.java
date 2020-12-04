/**Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []
Done by using backtracking where we first sort the array, so that we can end the recursion knowing that all the elements ahead will give a sum greater than target when they cross a threshold. We then backtrack by keeping track of the remaining target that has to be addded, we iterate the array from current starting index, if all the valid iterations of a current starting index are traversed, we then start all the iterations from the next index array.
TC-O(N^(T/M+1))
**/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans,list,candidates, 0, target);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> list, int[]nums,int pos,int target){
    	// if target becomes 0, it is valid, so we add it to answer
        if(target==0)ans.add(new ArrayList<>(list));
        // discard, when value exceeds target
        else if(target<0)return;
        else{
            for(int i=pos;i<nums.length;i++){
                list.add(nums[i]);
                target-=nums[i];
                dfs(ans,list,nums,i,target);
                // restoring target after removing element
                target+=list.remove(list.size()-1);
                
            }
        }
    }
}
