/** program to add missing ranges in a sorted array of elements in range lower to upper, with some ranges missing.
TC-O(N)
credits-https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/782/discuss/621426/Generic-Solution-100-for-Missing-Ranges-and-Summary-Ranges-questions
**/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            addRange(result, lower, upper);
            return result;
        }
        // 1. We don't need to add [Integer.MAX_VALUE, ....] to result
        if (lower == Integer.MAX_VALUE) return result;
        for (int num : nums) {
            if (lower < num) {
               addRange(result, lower, num - 1);
            }
            // 2. We don't need to preceed after we have process Integer.MAX_VALUE in array
            if (num == upper || num == Integer.MAX_VALUE) return result;
            lower = num + 1;
        }
        addRange(result, lower, upper);
        return result;
    }
    private void addRange(List<String> result, int lower, int upper) {
        if (lower <= upper) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            if (lower < upper)
                sb.append("->").append(upper);
            result.add(sb.toString());
        }
    }
}


