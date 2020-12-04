/** program to read binary watch, i.e return the list of possible times, in binary watch, given the no of lights that are turned on. Done using Integer.bitCount to find a match.
credits- https://leetcode.com/problems/binary-watch/discuss/313268/My-Java-Solution-to-401-(using-Integer.bitCount())
TC-O(720)
**/
class Solution {
    public List<String> readBinaryWatch(int num) {
    List<String> times=new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if((Integer.bitCount(i)+Integer.bitCount(j))==num){
                    StringBuilder sb=new StringBuilder();
                    sb.append(i);
                    sb.append(":");
                    sb.append((j<10?"0":"")+Integer.toString(j));
                    times.add(sb.toString());
                }
            }
        }
        return times;
    }
}
