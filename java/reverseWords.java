/** program to reverse the string words, by removing extra white spaces, as well. Done by trimming, splitting to remove white spaces. Then traversing backwards of string array.
TC-O(N)
**/
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String[] words=s.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            if(words[i]!=" "){
                sb.append(words[i]+" ");
            }
        }
        return sb.substring(0,sb.length()-1).toString();
    }
}
