/** program to reverse only letters in a given string. Done using manipulation of char array using two pointers, where letters where swapped only if both pointers were letters, otherwise, pointers were moved.
Credits for this amazing soln-https://leetcode.com/problems/reverse-only-letters/discuss/360790/Java-100-faster-100-memory-efficient
TC-O(N)
**/
class Solution {
    public String reverseOnlyLetters(String S) {
        int j = S.length() - 1;
        int i=0;
        char[] ch=S.toCharArray();
        while(i<j){
            while(!Character.isLetter(ch[i])&&i<j)i++;
            while(!Character.isLetter(ch[j])&&i<j)j--;
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;j--;
        }
        return new String(ch);
}
}
