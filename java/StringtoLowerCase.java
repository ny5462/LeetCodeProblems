/**program to convert string to lowercase letters, done by converting its ASCII
value, if it lies in the capital range of 65 to 90 , to its respective small ASCII 
value by adding 32 to it.
TC-O(N)
**/
class Solution {
    public String toLowerCase(String str) {
        String s="";
        for(int i=0;i<str.length();i++){
            int ch=(int)str.charAt(i);
            if(ch>=65&&ch<=90){
                s+=(char)(ch+32);
            }else{s+=(char)ch;}
        }
        return s;
    }
}
