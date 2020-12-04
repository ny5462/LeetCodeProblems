/**Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

TC-O(M+N+Max(M,N))
**/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] num1=version1.split("\\.");
        String[]num2=version2.split("\\.");
        
        int n1=num1.length,n2=num2.length;
        int i1,i2;
        for(int i=0;i<Math.max(n1,n2);i++){
            i1=i<n1?Integer.parseInt(num1[i]):0;
            i2=i<n2?Integer.parseInt(num2[i]):0;
            if(i1!=i2){
                return i1>i2? 1:-1;
            }
        }
        return 0;
            
    }
}
