package com.revature.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Map;
import java.util.Set;

public class JavaCollectionAnswers implements JavaCollection {

	@Override
	public List<Integer> digits(int n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		List<Integer> output = new ArrayList<Integer>();
		
		if (n == 0) {
			output.add(0);
			return output;
		}
		
		int length = (int) (Math.log10(n) + 1);
		
		for (int i = 0; i < length; i++) {
			double num = n % Math.pow(10, i);
			
			int numUsed = (int) (num / Math.pow(10, i));
			output.add(numUsed);
		}
		
		return output;
	}

	@Override
	public Set<?> sort(Object[] array) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Set openers = new HashSet();
		boolean hasChar;
	
		for(int i = 0; i < brackets.length(); i++) {
			char chr = brackets.charAt(i);

			switch(chr) {
			case '}':
				hasChar = openers.contains('{');
				if (hasChar) {
					openers.remove('{');
				} else {
					return false;
				}
				break;
			case ']':
				hasChar = openers.contains('[');
				if (hasChar) {
					openers.remove('[');
				} else {
					return false;
				}
				break;
			case ')':
				hasChar = openers.contains('(');
				if (hasChar) {
					openers.remove('(');
				} else {
					return false;
				}
				break;
			default: 
				openers.add(chr);
			}
			
		}
		return openers.size() == 0 ? true : false;
	}

	@Override
	public boolean isPalindrome(int n) throws IllegalArgumentException {	
		List<Integer> numbers = digits(n);
		int length = numbers.size();
		
		for (int i = 0; i < length / 2; i++) {
			if (numbers.get(i) != numbers.get(length - i - 1) ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Map<Character, Integer> countCharacters(String string) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		Map<Character, Integer> output = new HashMap<Character, Integer>();
		int count;
		
		for(int i = 0; i < string.length(); i++) {
			char chr = string.charAt(i);
			
			if (output.containsKey(chr)) {
				count = output.get(chr);
				output.put(chr, count+1);
			} else {
				output.put(chr, 1);
			}
		}
		return output;
	}

}
