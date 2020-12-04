/**program to count continous segments in the string ,
eg - " hi, i am x"- 4.
TC- O(N)
**/
class Solution {
    public int countSegments(String s) {
        if(s.length()==0)return 0;
        int count=1;
        if(s.startsWith(" "))count=0;
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(!(c==' ')&&s.charAt(i-1)==' '){
                count++;
            }
        }return count;
    }
}
