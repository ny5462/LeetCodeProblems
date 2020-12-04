/** program to find no of unique morse codes, given a array of words,
given-morse codes. The approach involves use of a hashmap to tore morese codes, 
and iterating and adding using nested for loops in hashset,hence unique codes are stored.
Faster approach would be to use an array with ascii difference indexing rather than hashmap.
TC-O(N*wordLength)
**/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character,String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
                map.put('a',".-");
                map.put('b',"-...");
                map.put('c',"-.-.");
                map.put('d',"-..");
                map.put('e',".");
                map.put('f',"..-.");
                map.put('g',"--.");
                map.put('h',"....");
                map.put('i',"..");
                map.put('j',".---");
                map.put('k',"-.-");
                map.put('l',".-..");
                map.put('m',"--");
                map.put('n',"-.");
                map.put('o',"---");
                map.put('p',".--.");
                map.put('q',"--.-");
                map.put('r',".-.");
                map.put('s',"...");
                map.put('t',"-");
                map.put('u',"..-");
                map.put('v',"...-");
                map.put('w',".--");
                map.put('x',"-..-");
                map.put('y',"-.--");
                map.put('z',"--.."); 
        for(int i=0;i<words.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                sb.append(map.get(words[i].charAt(j)));
            }
            set.add(sb.toString());
            }
                        return set.size();
                        }
                        }
                        
                   
        
    

