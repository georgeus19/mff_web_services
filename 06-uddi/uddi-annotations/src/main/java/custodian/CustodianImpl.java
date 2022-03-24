package custodian;

import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;


@UDDIService(
		businessKey="uddi:${keyDomain}:${department}",
		serviceKey="uddi:${keyDomain}:services-custodian${department}", 
		description = "Custodian service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-custodian${department}-wsdl",
	    description="WSDL endpoint for the hello${department} Service. This service is used for "
				  + "testing the jUDDI annotation functionality",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/custodian/services/custodian?wsdl")
@WebService(
		endpointInterface = "custodian.Custodian",
        serviceName = "Custodian")
public class CustodianImpl implements Custodian {
	
	public String StoreStock(int stockId) {
		return "Stock " + stockId + " stored.";
	}
	
	public String RemoveStock(int stockId) {
		return "Stock " + stockId + " removed from storage.";
	}

}
