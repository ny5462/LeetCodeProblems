/** program to check no of unique emails in an array, where characters after '+' are ignored, 
'.' is ignored before the domain name. '.' is valid after domain name.
TC-O(N)
**/
class Solution {
    public int numUniqueEmails(String[] emails) {
      Set<String> set=new HashSet<>();
        for(String email:emails){
            StringBuilder sb=new StringBuilder();
            boolean flag=false;
            boolean dot=false;
            for(char ch:email.toCharArray()){
                if(ch=='+'){
                    flag=true;
                }
                 else if(ch=='@'){
                    flag=false;
                    dot=true;
                    sb.append(ch);
                }
                else if(flag==false&&(ch!='.'||dot==true))sb.append(ch);
                        
            }
            //System.out.println(sb);
            set.add(sb.toString());
        }
          
    return set.size();
    }
}
