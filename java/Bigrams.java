/** program to find third element in text, if match for first and second consecutive elements in 
a text is found . Given text, first string, second string.
TC-O(N)
**/
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String collection="";
        String[] words=text.split(" ");
        if(words.length<3)return null;
        for(int i=0;i<words.length-2;i++){
            if(words[i].equals(first)&&words[i+1].equals(second))
                collection+=words[i+2]+" ";
        }
        if(collection.equals(""))return new String[0];
        collection=collection.substring(0,collection.length()-1);
        String[] ret=collection.split(" ");
        return ret;
    }
}
