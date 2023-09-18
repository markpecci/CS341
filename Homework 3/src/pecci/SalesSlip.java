package pecci;

import java.util.ArrayList;

public class SalesSlip {
	private String output = "";
	ArrayList<SalesItem> slip;
	
	public SalesSlip() {
		 slip = new ArrayList<SalesItem>();
	}

	public void addSalesItem(SalesItem s) {
		slip.add(s);
	}

	public String computeTotal() {
		double total = 0;
		if(slip.size() >= 1) {
			for(int i = 0; i < slip.size(); i++) {
				total += slip.get(i).getPrice() * slip.get(i).getQuantity();
			}
		}
		else {
			output = "Please enter some sales items";
			return output;
		}
		if(total < 10.00) {
			output = "$0" + String.format("%.2f", total);
			return output;
		}
		output = "$" + String.format("%.2f", total);
		return output;
	}

	public String toString() {
		String output = "";
		if(slip.size() < 1) {
			output = "Please enter some sales items";
			return output;
		}
		for (int i = 0; i < slip.size(); i++){
			output += slip.get(i).toString() + "\n";
		}
		return output;
	}
}
