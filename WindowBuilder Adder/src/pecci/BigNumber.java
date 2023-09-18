package pecci;

import java.util.ArrayList;
import java.util.Collections;

public class BigNumber {
	private String num1;
	private String num2;
	private int len1;
	private int len2;
	
	
	public BigNumber(String num1, String num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}
	
	public String addNumbers() {
		String done;
		//these are the lengths of our bignumbers
		
		len1 = num1.length();
		len2 = num2.length();
		
		//array lists were easier than arrays because they have not functions and are easier to work with and change after instantiation
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		//these fill our array lists with the contents of the string inputs
		for(int i = len1 - 1; i >= 0 ; i--) {
			char c = num1.charAt(i);
			int c2 = c - '0';
			arr1.add(c2);
		}
		
		for(int i = len2 - 1; i >= 0 ; i--) {
			char c = num2.charAt(i);
			int c2 = c - '0';
			arr2.add(c2);
		}
		
		//ADD LOOPS HERE TO GO THROUGH EACH ARRAY LIST AND LOOK FOR NONINTEGERS (TRY CATCH PARSEINT)
		
		answer = addArrays(arr1, arr2);
		return printAnswer(answer);
		
		
		
	}
	//this method takes the reverse ordered array list that added the two, flips it, and prints it out, accounting for unnecessary 0's in the first position
	public String printAnswer(ArrayList<Integer> answer) {
		
		StringBuilder sb = new StringBuilder();
		Collections.reverse(answer);
		int length = answer.size();
		
		for(int i = 0; i < length; i++) {
			if(answer.get(i) == 0 && i == 0) {
				continue;
			}
			sb.append(answer.get(i));
		}
		return sb.toString();
	}
	
	//this method adds the arrays
	public ArrayList<Integer> addArrays(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		int l1 = a1.size();
		int l2 = a2.size();
		int size;
		int difference;
		
		int num = 0;
		int carry = 0;
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		//this portion checks to see which is linger between the two, and adds to the shorter one to get aroudn boundary error
		if(l1 > l2) {
			size = l1;
			difference = l1 - l2;
			for(int i = 0; i < difference; i++) {
				a2.add(0);
			}
		} else if (l2 > l1) {
			size = l2;
			difference = l2 - l1;
			for(int i = 0; i < difference; i++) {
				a1.add(0);
			}
		} else {
			size = l1;
		}
		
		
		//this adds the arrays together into a third
		for(int i = 0; i < size; i++) {
			num = a1.get(i) + a2.get(i) + carry;
			if(num >= 10) {
				carry = 1;
				num -= 10;
			} else {
				carry = 0;
			}
			answer.add(num);
		}
		//we add the carry here in case there's a left over digit (1), but if we accidentally add a 0 it is taken out in our printing method
		answer.add(carry);
		return answer;
		
		//overall could be more optimal but it works and I rewrote it four times so I'm not touching a damn thing!
	}
	
//I will dock myself points for the error catch because for the life of me I couldn't figure out how. Interested to see the solution
	
}
