/** program to find if a sum of squares of all digits of a num adds upto 1, continue the process, till you find the no or end in a loop. Approach 2 without converting to strings.
TC-O(N*length of longest no)
**/
class Solution {
    public boolean isHappy(int n) {
        String num=String.valueOf(n);
        HashSet<Integer> set=new HashSet<>();
        int squared=0;
        while(true){
            for(char c:num.toCharArray()){
                squared+=Math.pow(Character.getNumericValue(c),2);
                
            }
            if(squared==1)break;
            else{
                if(set.contains(squared))return false;
                else{
                    set.add(squared);
                }
                num=String.valueOf(squared);
                squared=0;
            }
        }
        return true;
    }
}


class Solution {
    public boolean isHappy(int n) {
        String num=String.valueOf(n);
        HashSet<Integer> set=new HashSet<>();
        while(true){
            if(n==1)return true;
            if(set.contains(n))return false;
            set.add(n);
            int squared=0;
            while(n!=0){
                int rem=n%10;
                n=n/10;
                squared+=rem*rem;
            }
            n=squared;
        
        
    }
}
}
