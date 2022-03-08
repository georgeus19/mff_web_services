package custodian;

@javax.jws.WebService()
public interface Custodian {

	@javax.jws.WebMethod
	public String StoreStocks(int stockId);
	
	@javax.jws.WebMethod
	public String RemoveStocks(int stockId);
}
