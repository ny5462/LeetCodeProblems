/** Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.  

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]

Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
Done by sorting by start times and using two pointers for overlap, and in case of no match, we move ahead from interval that ends first
TC-O(NlogN)
credits- https://leetcode.com/problems/meeting-scheduler/discuss/408491/JavaC%2B%2B-Two-Pointer-Clean-code-O(NlogN)-for-Sorting-Beat-100
**/
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);
        int i=0,j=0;
        int s1=slots1.length;
        int s2=slots2.length;
        while(i<s1 && j<s2){
            int maxStart=Math.max(slots1[i][0],slots2[j][0]);
            int minEnd=Math.min(slots1[i][1],slots2[j][1]);
            
            if(maxStart+duration <= minEnd)
                return Arrays.asList(maxStart,maxStart+duration);
            else if(slots1[i][1]<slots2[j][1])
                i++;
            else
                j++;
            
        }
        return new ArrayList<>();
    }
}


