package stockmarket;

import javax.jws.WebService;

@WebService(endpointInterface = "stockmarket.StockMarket")
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
