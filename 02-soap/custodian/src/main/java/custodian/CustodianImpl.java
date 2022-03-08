package custodian;

@javax.jws.WebService(endpointInterface = "custodian.Custodian")
public class CustodianImpl implements Custodian {

	public CustodianImpl() {
		
	}
	
	public String StoreStock(int stockId) {
		return "Stock " + stockId + " stored.";
	}
	
	public String RemoveStock(int stockId) {
		return "Stock " + stockId + " removed from storage.";
	}

}
