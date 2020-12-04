/** program to find intersection of 2 arrays, that is return an array that is an intersection set of 2 arrays.
Approach 1 done using 2 hashmaps, each storing the number and its frequency in respective array.
The smaller hashmap is iterated and if both maps contain that key, the minimum value of that key is obtained by comparing both maps and the key is added in the array times the minimum value.
TC-O(N1), where N1 is the bigger of the two array.
Approach 2 involves the sorting the two arrays, and iterating them, if a match is found, at same index value in both array, it is added in the array to be returned, otherwise their values are comparaed, and the pointer in the lower valued array is incremented to catch up.
TC-O(NlogN+N)
**/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer,Integer> map=new HashMap<>();
         HashMap<Integer,Integer> map2=new HashMap<>();
        int [] arr= new int[Math.min(nums1.length,nums2.length)];
        int values=0;
        for(int i=0,j=0;i<nums1.length||j<nums2.length;i++,j++){
            if(i<nums1.length&&j<nums2.length){
                map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
                map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
            }
            else if(i>=nums1.length&&j<nums2.length){
              map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);   
            }
            else if(j>=nums2.length&&i<nums1.length){
                 map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
            }
        }
        if(map.size()>map2.size()){
            for(Integer i:map2.keySet()){
                if(map.containsKey(i)){
                    int value=Math.min(map.get(i),map2.get(i));
                    for(int v=values;v<value+values;v++){
                        arr[v]=i;
                    }
                    values=values+value;
                }
            }
        }else{
            for(Integer i:map.keySet()){
                if(map2.containsKey(i)){
                    int value=Math.min(map.get(i),map2.get(i));
                    for(int v=values;v<value+values;v++){
                        arr[v]=i;
                    }
                    values=values+value;
                }
        }
        }
        return Arrays.copyOfRange(arr, 0, values);
    }
}
/** approach 2 -credits to 
https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/333901/Java-Solution-easy-to-understand-beats-100-runtime
**/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] arr= new int[Math.min(nums1.length,nums2.length)];
        int values=0,i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                arr[values++]=nums1[i];
                i++;j++;
            }else if(nums1[i]<nums2[j]){
                ++i;
            }else{
                ++j;
            }
        }
        return Arrays.copyOf(arr,values);
    }
}
