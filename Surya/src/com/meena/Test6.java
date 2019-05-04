package com.meena;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test6 {

	public static void main(String[] args) {
		String str="meenakshi";
		char[] chars=str.toCharArray();
		Set<Character> set1=new LinkedHashSet<Character>();
		for(Character c:chars) {
			set1.add(c);
		}
		System.out.println(set1);
		StringBuffer sb=new StringBuffer();
		for(Character s:set1) {
			sb=sb.append(s);
		}
		System.out.println(sb);

	}

}
