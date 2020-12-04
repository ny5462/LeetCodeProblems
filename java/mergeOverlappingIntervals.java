/**Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping compares  two intervals at a time, and in case of overlap the first interval and second are merged and added to the arraylist, otherwise both are added as independent intervals.
TC-O(nlogn)
**/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[][]{};
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] second=intervals[i];
            int[] first=ans.remove(ans.size()-1);
            if(first[1]>=second[0]){
                ans.add(new int[]{first[0],Math.max(first[1],second[1])});
            }
            else{
                ans.add(first);
                ans.add(second);
            }
        }
        return ans.toArray(new int[ans.size()][]);
       
    }
}
