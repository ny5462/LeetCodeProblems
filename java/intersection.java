/** program to find intersection of 2 arrays. Done using 2 hashsets, and iterating the smaller set.
TC-O(N+M)
**/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int count=0;
        int [] arr=new int[min(n1,n2)];
        
        Set<Integer> m1=new HashSet<>();
        Set<Integer> m2=new HashSet<>();
        for(int i:nums1){
            m1.add(i);
        }
        for(int i:nums2){
            m2.add(i);
        }
        if(n1>n2){
            for(int i:m2){
                if(m1.contains(i))arr[count++]=i;
            }
            }
        else{
            for(int i:m1){
                if(m2.contains(i))arr[count++]=i;
            }
        }
        return Arrays.copyOfRange(arr,0,count);
        }
        
    
    public int min(int a, int b){
        return a>b?b:a;
    }
}
