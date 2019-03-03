/*
 * Find the largest palindrome made from the product of two prime 5-digit numbers
 */

import java.util.ArrayList;

public class Main {
	static int firstNum = 0;
	static int secondNum = 0;
	static boolean palindrome = false;
	static long answer = 0;

	public static void main(String[] args) {
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		
		for (int i = 9999; i < 99999; i++) {
			primeNums.add(i);
			for (int j = 2; j < Math.sqrt(i); j++) {
				if (i % j == 0) {
					primeNums.remove(new Integer(i));
					break;
				}
			}
		}
		
		for (int i = 0; i < primeNums.size(); i++) {
			for (int j = 0; j < primeNums.size(); j++) {
				long a = primeNums.get(i);
				long b = primeNums.get(j);
				if (palindrome(a*b) == true) {
					if (a * b > answer) {
						answer = a * b;
						firstNum = (int) a;
						secondNum = (int) b;
					}
				}
			}
		}
		
		output();
	}

	public static boolean palindrome(long mult) {
		String multNum = String.valueOf(mult);
		StringBuilder sb = new StringBuilder(multNum);
		String revMultNum = sb.reverse().toString();
		return multNum.equalsIgnoreCase(revMultNum);
	}

	public static void output() {
		System.out.println("Frist number: " + firstNum);
		System.out.println("Second number: " + secondNum);
		System.out.println("Answer: " + answer);
	}
}
