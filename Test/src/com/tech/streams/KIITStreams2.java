package com.tech.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class KIITStreams2 {

	public static void main(String[] args) {
		List<String> words = new ArrayList(Arrays.asList("Note","Tone","silent","listen","Sun","nus"));
		System.out.println(words);
		

		Map<String ,List<String>> groupedBylength = new HashMap<>();
		for(String word: words) {
			char [] arr = word.toLowerCase().toCharArray();
			Arrays.sort(arr);
			String key = new String (arr);
			groupedBylength.putIfAbsent(key,new ArrayList<String>());
			groupedBylength.get(key).add(word);
		}
//		System.out.println(groupedBylength.values());
		
//		Using Streams
		
		Map<String ,List<String>> groupedBylength2 = words.stream().collect(Collectors.groupingBy(str -> anagram(str))); //Lambda expression
		System.out.println(groupedBylength2.values());
		
		Map<String ,List<String>> groupedBylength3 = words.stream().collect(Collectors.groupingBy(KIITStreams2 ::anagram));    //method referencing
		System.out.println(groupedBylength3.values());
		
																								//Actual task          Extra Task -> means DownStream
		Map<Boolean ,Long> partitionBylength = words.stream().collect(Collectors.partitioningBy(str ->str.length()<=3 , Collectors.counting()));    
		System.out.println(partitionBylength);
	}
	
	private static String anagram(String str) {
		char [] arr = str.toLowerCase().toCharArray();
		Arrays.sort(arr);
		String s = new String(arr);
		return s;
	}
}
