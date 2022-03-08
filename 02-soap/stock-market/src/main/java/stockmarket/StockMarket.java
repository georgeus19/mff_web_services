package stockmarket;

@javax.jws.WebService
public interface StockMarket {
	
	@javax.jws.WebMethod
	public StockList ShowAvailableStocks();
	
	
	// For simplicity, I return AvailableStock even though it is not semantically correct...
	@javax.jws.WebMethod
	public AvailableStock BuyStocks(int id, int count);

}
