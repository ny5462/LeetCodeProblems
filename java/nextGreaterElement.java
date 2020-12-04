/** program to find next greater element in the right of the corresponding element
in nums2. i. e for every element in nums1(subset of nums2), find if there is an element greater
than it in nums2 to its right, if not add -1 to the array
TC-O(N^2)
**/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] arr=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int num=nums1[i];
            int temp=map.get(num)+1;
            while(temp!=nums2.length){
                if(nums2[temp]>num){
                    arr[i]=nums2[temp];
                    break;
                }else{
                    temp++;
                }
            }if(temp>=nums2.length){
                arr[i]=-1;
            }
        }   
        return arr;
    }
}
