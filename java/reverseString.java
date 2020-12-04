/** function to reverse a string inplace in an array
TC-O(n/2)
**/
class Solution {
    public void reverseString(char[] s) {
        if(s.length==0|| s.length==1)return ;
        for(int i=s.length-1;i>=s.length/2;i--){
            char temp=s[i];
            s[i]= s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    
    }
}
