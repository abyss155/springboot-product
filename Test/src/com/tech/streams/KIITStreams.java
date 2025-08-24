package com.tech.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KIITStreams {

	public static void main(String[] args) {
		List<String> words = new ArrayList(Arrays.asList("One","Two","Three","Four","Five","Six","Six"));
		System.out.println(words);
		
		
		//group their String as per Length
//		3--> ["One","Two","Six"] 
//		4--> ["Four", "Five"]
//		5--> ["Three"]
		
//		Without using Streams
		
		Map<Integer , List<String>> groupBylength  = new HashMap();
		for(String word :words) {
			int length = word.length();
			groupBylength.putIfAbsent(length, new ArrayList<String>());
			groupBylength.get(length).add(word);
			
		}
//		System.out.println(groupBylength.values());
		
		
//		Using streams 
		
		Map<Integer, List<String>> groupBylength2 = words.stream().collect(Collectors.groupingBy(s->s.length())); //Lambda expression
		System.out.println(groupBylength2.values());

		
		Map<Integer, List<String>> groupBylength3 = words.stream().collect(Collectors.groupingBy(String::length)); //method referencing
		System.out.println(groupBylength3.values());

		

	}

}
