// Leetcode Link: https://leetcode.com/problems/two-sum/
// Perfom on Online Compiler

import java.util.*;
class Solution {
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return Character.toString((char)258);
        }
        StringBuilder sb = new StringBuilder();
        String separate = Character.toString((char)257);
        
        for (String s: strs) {
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public List<String> decode(String s) {        
        if (s.equals(Character.toString((char)258))) {
            return new ArrayList<>();
        }      
        String separate = Character.toString((char)257);
        return Arrays.asList(s.split(separate, -1));
    }
    
	public static void main(String[] args) {
	    List<String> strs = Arrays.asList("abc", "ab", "xy");
	    System.out.println("Original List of String: " + strs);
	    
		Solution codec = new Solution();
		
		String encodedString = codec.encode(strs);
		System.out.println("Encoded String: " + encodedString);
		
		List<String> decodedString = codec.decode(encodedString);
		System.out.println("Decoded String: " + decodedString);
	}
}