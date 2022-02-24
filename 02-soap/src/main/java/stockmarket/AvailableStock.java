package stockmarket;

public class AvailableStock {
	
	private Stock stock;
	private int count;
	
	public AvailableStock(Stock stock, int count) {
		super();
		this.stock = stock;
		this.count = count;
	}
	
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
}
