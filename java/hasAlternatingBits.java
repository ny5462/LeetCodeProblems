/** program to find whether there are consecutive bits who are same in given string.
TC-O(N)
**/
class Solution {
    public boolean hasAlternatingBits(int n) {
     String bin= Integer.toBinaryString(n) ;
    if(bin.length()==1)return true;
    for(int i=0;i<bin.length()-1;i++){
        if(bin.charAt(i)==bin.charAt(i+1))return false;
    }
        return true;
    }
}
