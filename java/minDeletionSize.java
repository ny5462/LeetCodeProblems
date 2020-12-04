/** program to find in an array of strings, whether any column isn't sorted, and return the count of unsorted columns, i.e ["abc","loa"], so columns would be ["a","l"],["b","o"],[""c","a"]
, so output would be 3 as none of the columns are sorted. Done using greedy approach.
TC-O(A), all the letters.
credits-https://leetcode.com/problems/delete-columns-to-make-sorted/solution/
**/
class Solution {
    public int minDeletionSize(String[] A) {
        int diff=0;
     for(int i=0;i<A[0].length();i++){
         for(int j=0;j<A.length-1;j++){
             if(A[j].charAt(i)>A[j+1].charAt(i)){
                 diff++;
                 break;
         }
     }   
        
    }return diff;
    }
}


/** approach 2 , much faster **/
class Solution {
    public int minDeletionSize(String[] A) {
      int diff=0;
     int len=A[0].length();
        for(int i=0;i<len;i++){
            if(noSort(i,A))diff++;
        }
        return diff;
    }
    public boolean noSort(int num,String [] A){
        char c=A[0].charAt(num);
        for(int i=0;i<A.length;i++){
            if(c>A[i].charAt(num))return true;
            c=A[i].charAt(num);
        }
        return false;
    }
}


