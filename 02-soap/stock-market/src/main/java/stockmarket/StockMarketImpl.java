package stockmarket;

import java.util.Arrays;

import javax.jws.WebService;

@javax.jws.WebService
public class StockMarketImpl implements StockMarket {
	
	private StockList stockList;
	
	public StockMarketImpl(StockList stockList) {
		super();
		this.stockList = stockList;
	}

	public StockList showAvailableStocks() {
		return stockList;		
	}
	
	public AvailableStock buyStocks(int id, int count) {
		return stockList.getStocks(id, count);
	}

	
}
