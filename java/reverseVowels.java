/**
Program to reverse position of vowels, eg -"hello"-->"holle"
TC-O(n). used char array, added index of vowels in an arraylist,
swapped the array according to index, converted char array to string
**/
class Solution {
    public String reverseVowels(String s) {
        if(s.length()==1||s.length()==0)return s;
        char[] s1=s.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s1.length;i++){
            if(s1[i]=='a'||s1[i]=='e'||s1[i]=='i'||s1[i]=='o'||s1[i]=='u'
              ||s1[i]=='A'||s1[i]=='E'||s1[i]=='I'||s1[i]=='O'||s1[i]=='U'){
                list.add(i);
            }
        }for(int i=0;i<list.size()/2;i++){
            char temp =s1[list.get(i)];
            s1[list.get(i)]=s1[list.get(list.size()-1-i)];
            s1[list.get(list.size()-1-i)]=temp;
        }
        String string =new String (s1);
        return string;
    }
}
