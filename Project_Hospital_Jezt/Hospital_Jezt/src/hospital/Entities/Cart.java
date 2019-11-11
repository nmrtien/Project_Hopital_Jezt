package hospital.Entities;

public class Cart {
	
	private int quantity;
	private Medicine med;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int quantity, Medicine med) {
		
		this.quantity = quantity;
		this.med = med;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}
	
	
	
}
