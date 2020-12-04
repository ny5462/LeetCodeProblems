/** finding all possible subsets of a given array. DOne using backtracking by having an index of iteration as well. Where we first add the temp list in answer by cloning it, we then iterate forwards from the given index recursively by increasing the index, after we get back to parent node of recursion, we remove the last added element to look for a different combination in the same array.
TC-O(N*2^N)
credits- https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
**/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(ans,list,nums,0);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> list, int[]nums, int pos){
        ans.add(new ArrayList<>(list));
        // starting loop from given index to look at remaning array
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            // recursing elements that lie ahead
            dfs(ans,list,nums,i+1);
            // removing from temp list to look ahead for a different combination
            list.remove(list.size()-1);
        }
    }
}
