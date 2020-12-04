/** Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: 9973
Output: 9973
Explanation: No swap.

Done by maintaining a char array of digits and int array storing last occuring index of every digit. Then we do traverse the char Array from start and then int array from last, if we find a pair such that index of number in char Array is less than index of bigger elements in int array, we swap them.
credits- https://leetcode.com/problems/maximum-swap/solution/
TC-O(N)
Integer.valueOf(String ) is faster than Integer.parseInt(String)
**/

class Solution {
    public int maximumSwap(int num) {
        char [] A=Integer.toString(num).toCharArray();
        int [] last=new int[10];
        for(int i=0;i<A.length;i++){
            last[A[i]-'0']=i;
        }
        
        for(int i=0;i<A.length;i++){
            for(int d=9;d>A[i]-'0';d--){
                if(last[d]>i){
                    char tmp=A[i];
                    A[i]=A[last[d]];
                    A[last[d]]=tmp;
                    return Integer.valueOf(new String(A));
                }
                
            }
        }
        return num;
    }
}
