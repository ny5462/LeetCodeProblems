/** program to find the character that is different from 2 almost identical strings in terms of character.
TC-O(N)
**/
class Solution {
    public char findTheDifference(String s, String p) {
        int[] s1=new int[26];
        char c='\u0000';
        for(int i=0;i<s.length();i++){
            s1[s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<p.length();i++){
            s1[p.charAt(i)-'a']+=0;
            if(s1[p.charAt(i)-'a']==0){
                return p.charAt(i);
            }else{
                s1[p.charAt(i)-'a']--;   
            }
        }
        return  c; 
    }
}
