package stockmarket;

import java.util.List;

public class StockList {
	private List<AvailableStock> stocks;

	public StockList(List<AvailableStock> stocks) {
		super();
		this.stocks = stocks;
	}

	public List<AvailableStock> getStocks() {
		return stocks;
	}

	public void setStocks(List<AvailableStock> stocks) {
		this.stocks = stocks;
	}
	
	public AvailableStock getStocks(int id, int count) {
		AvailableStock availableStock = stocks.stream()
				.filter(as -> id == as.getStock().getId())
				.findAny()
				.orElse(null);
		if (!availableStock.equals(null)) {
			if (availableStock.getCount() >= count) {
				availableStock.setCount(availableStock.getCount() - count);
				return new AvailableStock(availableStock.getStock(), count);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	

}
