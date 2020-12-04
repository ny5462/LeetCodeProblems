/** program to put longest substring with non repeating characters, done by using 2 pointers and hashset, where keep on adding character to set till you encounter a duplicate character, once enountered, keep on deleting from set from previous counter till the duplicate character is removed, then move ahead with the forward counter..
TC-O(2n)
**/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
