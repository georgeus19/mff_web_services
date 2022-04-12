package custodianRest;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class CustodianApplication extends ResourceConfig {

	public CustodianApplication() {
		packages("custodianRest");
	}

}

