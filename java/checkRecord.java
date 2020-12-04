/** program to check student attendance
if more han 2 continous L- false or more than absent - false,
TC- O(N)
**/
class Solution {
    public boolean checkRecord(String s) {
        if(s==null)return true;
        int late=0;
        int absent=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                absent++;
                if(absent>1)return false;
            }if(s.charAt(i)=='L'){
                late++;
                if(late>2)return false;
            }
            else{late=0;}
        }return true;
    }
}
