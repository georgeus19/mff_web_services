package custodiancxf;

import javax.jws.WebService;

@WebService(targetNamespace = "http://custodiancxf/", endpointInterface = "custodiancxf.Custodian", portName = "CustodianImplPort", serviceName = "CustodianImplService")
public class CustodianImpl implements Custodian {

	public String StoreStock(int stockId) {
		return "Stock " + stockId + " stored.";
	}
	
	public String RemoveStock(int stockId) {
		return "Stock " + stockId + " removed from storage.";
	}

}
