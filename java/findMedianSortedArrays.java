/** find median of 2 sorted arrays, done by merge and finding middle element, standard median style
TC-O(m+n)
SC-O(m+n)
**/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        if(nums1.length==0)nums=nums2;
        else if(nums2.length==0)nums=nums1;
        else{
             int i=0,j=0,k=0;
            while(k<nums.length && i<nums1.length && j<nums2.length){
                if(nums1[i]>nums2[j]){
                    nums[k++]=nums2[j++];
                }else{
                    nums[k++]=nums1[i++];
                }
            }
            while(i<nums1.length){
                nums[k++]=nums1[i++];
            }
            while(j<nums2.length){
                nums[k++]=nums2[j++];
        }
        }
       
        // for(int x:nums){
        //     System.out.println(x);
        // }
        if(nums.length%2==1){
            return nums[nums.length/2];
        }else{
            return (nums[nums.length/2]+nums[(nums.length/2)-1])/2.0;
        }
    }
}
