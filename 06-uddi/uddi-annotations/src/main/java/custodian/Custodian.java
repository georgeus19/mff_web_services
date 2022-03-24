package custodian;

@javax.jws.WebService()
public interface Custodian {

	@javax.jws.WebMethod
	public String StoreStock(int stockId);
	
	@javax.jws.WebMethod
	public String RemoveStock(int stockId);
}
