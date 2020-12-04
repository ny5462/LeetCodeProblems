/** program to find length of last word with strings which can contains only empty spaces as well.
Done using a for loop where, starting from behind. If a non space character is read, it keeps on iterating, and adding the counter, till either the string ends or a space is encountered.
TC-O(N) ( either entire length of string is traversed, which contains empty spaces, or till last word is read)
**/
class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                while(i>=0&&s.charAt(i)!=' '){
                    count++;
                    i--;
                }
                return count;
            }
            
        }
        return count;
    }
}
