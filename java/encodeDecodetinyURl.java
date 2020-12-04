/** program to encode and decode strings to tinyUrls, done using 2 hashmaps.
TC-O(1)
**/
public class Codec {

    // Encodes a URL to a shortened URL.
    HashMap<String,String> map1 =new HashMap<>();
    HashMap<String, String> map2=new HashMap<>();
    String tiny="http://tinyurl.com/";
    public String encode(String longUrl) {
        String hash=Integer.toString(longUrl.hashCode())  ;
        String ret=tiny+hash;
        map1.put(longUrl,ret);
        map2.put(ret,longUrl);
        return ret;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map2.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
