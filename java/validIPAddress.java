/** program to check whether given string is a valid ip address, done by checking for ip4 and ip6 differently, splitting the strings, and checking for proper conditions for satisfaction.
TC-O(N)
**/
class Solution {
    public String validIPAddress(String IP) {
        final String neither="Neither";
        final String ip4="IPv4";
        final String ip6="IPv6";
        if(IP.endsWith(".")||IP.endsWith(":"))return neither;
        if(validIP4(IP))return ip4;
        else if(validIP6(IP))return ip6;
        else return neither;
    }
    public boolean validIP4(String ip){
        String[] words=ip.split("\\.");
        if(words.length!=4)return false;
        for(String i:words){
            char[] ch=i.toCharArray();
            for(char c:ch){
                if(!(Character.isDigit(c)||Character.isLetter(c)))return false;
            }
            if(i.startsWith("0")&&i.length()>1)return false;
            try{
            int num=Integer.parseInt(i);
            if(num>255||num<0)return false;
            }catch(Exception e){
                return false;
            }
           
        }
        return true;
    }
    public boolean validIP6(String ip){
        String[] words= ip.split("\\:");
        if(words.length!=8)return false;
        for(String i:words){
            if(i.length()==0)return false;
            char[] ch=i.toCharArray();
    
            for(char c:ch){
                if(!(Character.isDigit(c)||Character.isLetter(c)))return false;
                if(Character.isLetter(c)){
                    if(Character.isUpperCase(c)){
                        if(c>'F')return false;
                    }else if(c>'f')return false;
                
                }
            }
            if(i.length()>4)return false;
        }
        return true;
        
    }
    
}
