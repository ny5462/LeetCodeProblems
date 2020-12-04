/** program to defang IP4 address, where . is replaced by "[.]".
TC-O(N)
**/
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }return sb.toString();
    }
}
