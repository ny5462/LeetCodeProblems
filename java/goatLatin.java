/** program to write in goat latin
The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.
TC-O(N)
**/
class Solution {
    public String toGoatLatin(String S) {
        StringBuilder sb=new StringBuilder();
        String [] words=S.split(" ");
        HashSet<Character> vowels =new HashSet();
         for(char c:new char[]{'a','e','i','o','u','A','E','I','O','U'}){
             vowels.add(c);
         }
        String ma="ma";
        for(int i=0;i<words.length;i++){
            if(vowels.contains(words[i].charAt(0))){
                ma+="a";
                words[i]+=ma;
            }else{
                ma+="a";
                if(words[i].length()==1)words[i]+=ma;
                else {
                    char c=words[i].charAt(0);
                    words[i]=words[i].substring(1,words[i].length())+c+ma;
            }
        }
        }
        for(String str:words){
            sb.append(str+" ");
        }
        return sb.substring(0,sb.length()-1).toString();
    }
}
            
            
