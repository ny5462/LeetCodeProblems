/** program to find hamming distance between two integers, that is differnce of digits in their binary equivalent, done by converting them to binary strings and traversing each character.
Approach 2 involves Bit manipulation , interesting and more to learn from it. 
Taken from https://leetcode.com/problems/hamming-distance/discuss/323117/C-solution-100-faster
TC-O(N)**/
class Solution {
    public int hammingDistance(int x, int y) {
        String xs=Integer.toBinaryString(x);
        String ys=Integer.toBinaryString(y);
        int max,min=0;
        int dist=0;
        if(xs.length()>=ys.length()){
            max=xs.length();
            min=ys.length();
        }
        
        else{
            max=ys.length();
            min=xs.length();
        }
        for(int i=xs.length()-1,j=ys.length()-1;i>=0&&j>=0;i--,j--){
            if(xs.charAt(i)!=ys.charAt(j))dist++;
        }
        if(max==xs.length()){
            for(int i=0;i<max-min;i++){
                if(xs.charAt(i)=='1')dist++;
            }
        }
        else if(max==ys.length()){
            for(int i=0;i<max-min;i++){
                if(ys.charAt(i)=='1')dist++;
            }
        }
        return dist;
    }
}


class Solution {
    public int hammingDistance(int x, int y) {


    int z = x^y;
    
    int distance = 0;
        
    while(z>0)
    {
        distance += (z%2) ;
        z /= 2;
    }
    
    return distance;
}
}

