package custodiancxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "Custodian", targetNamespace = "http://custodiancxf/")
public interface Custodian {

	@WebMethod(operationName = "StoreStock", action = "urn:StoreStock")
	public String StoreStock(int stockId);
	
	@WebMethod(operationName = "RemoveStock", action = "urn:RemoveStock")
	public String RemoveStock(int stockId);
}
