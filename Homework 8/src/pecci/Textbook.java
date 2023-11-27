package pecci;

import java.io.Serializable;

public class Textbook implements Serializable{

    private static final long serialVersionUID = 1L;

	public int sku;
	public String title;
	public double price;
	public int quantity;

	public Textbook(int sku, String title, double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
