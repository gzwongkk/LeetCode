package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {

	/**
	 * Given an arrays of strings, return all groups of strings that are anagrams.
	 * Note: All inputs will be in lower-case.
	 **/
	public static void main(String[] args) {
		String[] strs = new String[]{"silent", "listen","dog"};
		for( String str : anagrams(strs) )
			System.out.println(str);
	}

	/*
	 * Anagrams must use the same letters exactly once, so a slightly better solution than brute
	 * force is to sort the input arrays by length, and do comparisons within each length group. 
	 * This is basically radix sort. And speaking of radix sort, it uses counting sort and buckets. 
	 * Then it gives another idea which takes advantage of which sorted anagrams are all the same. 
	 */
	public static List<String> anagrams(String[] strs){
		ArrayList<String> ans = new ArrayList<String>();
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for( String str : strs ){
			char[] strChar = str.toCharArray();
			Arrays.sort(strChar);
			LinkedList<String> bucket = map.get(new String(strChar));
			if( bucket == null ){
				bucket = new LinkedList<String>();
				bucket.add(str);
				map.put(new String(strChar), bucket);
			} else bucket.add(str);
		}
		for( String str: map.keySet() ){
			LinkedList<String> bucket = map.get(str);
			if( bucket.size() != 1 ) ans.addAll(bucket);
		}
		return ans;
	}
}
