package custodian;

@javax.jws.WebService(endpointInterface = "custodian.Custodian")
public class CustodianImpl implements Custodian {

	public CustodianImpl() {
		
	}
	
	public String StoreStocks(int stockId) {
		return "Stock " + stockId + " stored.";
	}

}
