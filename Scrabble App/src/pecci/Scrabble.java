package pecci;

public class Scrabble {
	private String l1;
	private String l2;
	private String l3;
	private String l4;
	private static String output = "";
	public boolean error = false;

	public Scrabble(String l1, String l2, String l3, String l4) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}
	
	public void setL1(String l1) {
		this.l1 = l1;
	}
	
	public void setL2(String l2) {
		this.l2 = l2;
	}
	
	public void setL3(String l3) {
		this.l3 = l3;
	}
	
	public void setL4(String l4) {
		this.l4 = l4;
	}
	
	public String getL1() {
		return l1;
	}
	
	public String getL2() {
		return l2;
	}
	
	public String getL3() {
		return l3;
	}
	
	public String getL4() {
		return l4;
	}
	
	public String getOutput() {
		return output;
	}

	public void checkLetters() {
		if(l1.length() !=1 || l2.length() !=1 || l3.length() !=1 || l4.length() !=1) {
			output = "One letter per box please! \n";
			error = true;
		}
		char a1 = l1.toUpperCase().charAt(0);
		char a2 = l2.toUpperCase().charAt(0);
		char a3 = l3.toUpperCase().charAt(0);
		char a4 = l4.toUpperCase().charAt(0);
		if(!Character.isLetter(a1) || !Character.isLetter(a2) || !Character.isLetter(a3) || !Character.isLetter(a4)) {
			output = "Ensure entries are letters \n";
			error = true;
		}
		else if (!error){
			output = "Here you go: \n";
		}
	}
	
	public static void permutations(String str,String ans){
			if (str.length() == 0) {
				output += ans + " ";
				return;
			}
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				String ros = str.substring(0, i) + str.substring(i + 1);
				permutations(ros, ans + ch);
			}
		}
}

