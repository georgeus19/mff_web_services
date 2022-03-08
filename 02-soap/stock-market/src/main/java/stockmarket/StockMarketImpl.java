package stockmarket;

import javax.jws.WebService;

@WebService(endpointInterface = "stockmarket.StockMarket")
public class StockMarketImpl implements StockMarket {
	
	private StockList stockList;
	
	public StockMarketImpl(StockList stockList) {
		super();
		this.stockList = stockList;
	}

	public StockList ShowAvailableStocks() {
		return stockList;		
	}
	
	public AvailableStock BuyStocks(int id, int count) {
		return stockList.getStocks(id, count);
	}

	
}
