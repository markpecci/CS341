package pecci;

import java.util.ArrayList;
import java.util.Collections;

public class Password {
	
	private String input;
	
	public Password(String inp) {
		this.input = inp;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
	public String checkPassword() {
		String password = input;
		String output;
		int largestBlock = 0;
		int blockDiff;
		
		if(input.indexOf('`') != -1) {
			output = "Error: please do not use forbidden character '`'";
			return output;
		}
		
		largestBlock = checkBlockSize(password);
		
		blockDiff = (2 - largestBlock) / -1;
		
		if(largestBlock <= 2) {
			output = "You have a strong password. Your largest block is " + largestBlock;
		} else {
			output = "Your password is a little weak. Your largest block is " + largestBlock + 
					". This password can be made better by reducing this block by " + blockDiff;
		}

		return output;
	}
	
	public int checkBlockSize(String input) {
		int length = input.length();
		char lastChar = '-';
		char nowChar = '-';
		int currentBlock = 1;
		ArrayList<Integer> outputs = new ArrayList<Integer>();
		int output;
		
		for(int i = 0; i < length + 1; i++) {
			if(i == 0) {
				lastChar = input.charAt(0);
				continue;
			}
			
			if(i < length) {
				nowChar = input.charAt(i);
			} else {
				nowChar = '`';
			}
			
			if(nowChar == lastChar) {
				currentBlock += 1;
			} else {
				outputs.add(currentBlock);
				currentBlock = 1;
			}
			lastChar = nowChar;
		}
		
		output = Collections.max(outputs);
		return output;
	}
}
