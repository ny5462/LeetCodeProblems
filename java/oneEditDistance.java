/** program to see if s can become t by one edit, that is by removing 1 c, adding one c or replacing 1 c.
TC-O(N)
**/
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()==t.length()&&s.length()>0){
            return replace(s,t);
        }
        if(Math.abs(s.length()-t.length())>1)return false;
        if(s.length()>t.length()){
            return insertOne(s,t);
        }
        return insertOne(t,s);
    }
    
    public boolean replace(String s,String t){
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i))count++;
            if(count>1)return false;
        }
        return count==1;
    }
    
    public boolean insertOne(String s,String t){
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1)return true;
            if(s.charAt(i)!=t.charAt(i)){
                return s.substring(i+1).equals(t.substring(i));
            }
        }
        return false;
    }
}
