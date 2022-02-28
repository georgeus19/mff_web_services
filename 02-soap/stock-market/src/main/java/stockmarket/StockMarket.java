package stockmarket;

@javax.jws.WebService
public interface StockMarket {
	
	@javax.jws.WebMethod
	public StockList showAvailableStocks();
	
	
	// For simplicity, I return AvailableStock even though it is not semantically correct...
	@javax.jws.WebMethod
	public AvailableStock buyStocks(int id, int count);

}
