/** program to find legal capital use,
i.e eg- USA, Google, abc
either not used, either all capitals or first letter Capital
TC-O(N)
**/
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==0)return true;
        if(word.length()==1)return true;
        if(word.charAt(0)>='A'&&word.charAt(0)<='Z'){
            if(word.charAt(1)>='A'&&word.charAt(1)<='Z'){
                for(int i=1;i<word.length();i++){
                    char c=word.charAt(i);
                    if(!(c>='A'&&c<='Z'))return false;
                }
            }
            else{
                for(int i=1;i<word.length();i++){
                    char c =word.charAt(i);
                    if(c>='A'&&c<='Z')return false;
                }
            }
        }
        else if(word.charAt(0)>='a'&&word.charAt(0)<='z'){
            for(int i=1;i<word.length();i++){
            char c=word.charAt(i);
                if(c>='A'&&c<='Z'){
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
