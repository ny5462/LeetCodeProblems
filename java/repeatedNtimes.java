/** program to find in an array of length N, whenre N+1 unique nums are there, whether,
any number is repeated N Times. DOne using hashmap, where frequencies are stored and later
traversed the keyset.
TC-O(N)
**/
class Solution {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:A){
            map.put(i,map.getOrDefault(i,0)+1);
        }
       for(int k:map.keySet())
           if(map.get(k)>1)return k;
    
    throw null;
    }
}

/**Ideal solution where frequency is checked while inserting itself, if count >1 is encountered
, it is returned. By-https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/324889/Java-100
TC-O(N)
**/
	public int repeatedNTimes(int[] A) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int size = A.length;
        //int N = size/2;
        for(int i = 0; i <size; i ++){

           int count = map.getOrDefault(A[i],0);
           //if (count +1 == N)... was the better way
           if(count > 0) {
               return A[i];
           }
           map.put(A[i],count + 1);
        }
        return 0;

    }

