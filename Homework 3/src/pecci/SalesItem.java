package pecci;

public class SalesItem {
	private String item;
	private double price;
	private int quantity; 
	private double total;

	public SalesItem(String item, double price, int quantity) {
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String i) {
		item = i;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double p) {
		price = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int q) {
		quantity = q;
	}

	public double calcTotal() {
		return quantity * price;
	}

	public String toString() {
		String output = item;
		for(int i = 0; i < 15 - item.length(); i++ ) {
			output += " ";
		}
		output += "$";
		if(price < 10.0) {
			output += "0" + price;
		}
		else {
			output += price;
		}
		for(int j = 0; j < 5; j++) {
			output += " ";
		}
		output += quantity;
		return output;
	}
}
