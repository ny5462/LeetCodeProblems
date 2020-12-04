/** longest palindrome in  a string. Done by first storing frequencies in char array .  keeping a count of length, if there are even no of characters, we add it to longest string, if the length of string is even, and we read a character , that has odd freq, we can first add all of the pairs it forms, and then, if the string length is even, we can add an odd character, which can vary.
TC-O(N)
**/

class Solution {
    public int longestPalindrome(String s) {
        int [] count=new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
    

