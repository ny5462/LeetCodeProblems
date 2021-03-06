/**
 Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]

We should return

[1, 4, 3, 2, 0]

TC-O(N)
**/
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int [] ans= new int[A.length];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<B.length;i++){
            if(!map.containsKey(B[i])){
                map.put(B[i],new ArrayList<Integer>());
            }
            map.get(B[i]).add(i);
        }
        int index=0;
        for(int i=0;i<A.length;i++){
            ans[index++]=map.get(A[i]).remove(0);
        }
        return ans;
    }
}
