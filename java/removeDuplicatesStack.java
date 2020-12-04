/** program to remove all duplicates from string which occure one after another, even after removal of other characters, using a stack and stringbuilder, modifying them while pushing and popping .TC- O(N)
**/
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuillder();
        for(int i=0;i<S.length();i++){
            if(stack.empty()){
                stack.push(S.charAt(i));
                sb.append(S.charAt(i));
            }else{
                if(stack.peek().equals(S.charAt(i))){
                    stack.pop();
                    sb.delete(sb.length()-1,sb.length());
                }
                else{
                    stack.push(S.charAt(i));
                    sb.append(S.charAt(i));
                }
            }
        }
        return sb.toString();
    }
               
}

/** ideal solution with better space time complexity 
**/
class Solution {
  public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    int sbLength = 0;
    for(char character : S.toCharArray()) {
      if (sbLength != 0 && character == sb.charAt(sbLength - 1))
        sb.deleteCharAt(sbLength-- - 1);
      else {
        sb.append(character);
        sbLength++;
      }
    }
    return sb.toString();
  }
}
