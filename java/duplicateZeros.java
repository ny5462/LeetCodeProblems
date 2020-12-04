/** program to duplicate zeros in a position next next to it.
TC-O(n)
**/
class Solution{
	public void duplicateZeros(int [] arr){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.length;i++){
		sb.append(arr[i]);
		if(arr[i]==0){
			sb.append(0);
			}
		}
		for(int i=0;i<arr.length;i++){
		arr[i]=Character.getNumericValue(sb.charAt(i));
		}
	}

