package custodian.client;


import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class Client {

	public static void main(String[] args) throws Exception {
		StoreStock(42);
		
		RemoveStock(53);
	}
	
	public static void StoreStock(Integer stockId) throws Exception {
		SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
		SOAPConnection soapc = soapcf.createConnection();

		MessageFactory mf = MessageFactory.newInstance();
		SOAPMessage soapm = mf.createMessage();
		    
		SOAPPart soapp = soapm.getSOAPPart();
		SOAPEnvelope soape = soapp.getEnvelope();
		SOAPBody soapb = soape.getBody();

		soape.getHeader().detachNode();
		
		QName name = new QName("http://custodian/", "StoreStock");
		SOAPElement soapel = soapb.addBodyElement(name);

		soapel.addChildElement(
		    new QName("arg0")).addTextNode(stockId.toString());
		
		String endpoint = "http://127.0.0.1:8000/Custodian";
		
		SOAPMessage response = soapc.call(soapm, endpoint);
		soapc.close();
		
		SOAPBody responseBody = response.getSOAPBody();
		if (responseBody.hasFault()) {
		    System.out.println(responseBody.getFault().getFaultString()); 
		} else {
		    
			QName StoreStockResponseName = new QName("http://custodian/", "StoreStockResponse");
			QName returnName = new QName("return");
	
			SOAPBodyElement StoreStockResponse = (SOAPBodyElement)
			       responseBody.getChildElements(StoreStockResponseName).next();
			SOAPBodyElement res = (SOAPBodyElement)
					StoreStockResponse.getChildElements(returnName).next();
	
			System.out.println(res.getValue());
			
		}
	}
	
	public static void RemoveStock(Integer stockId) throws Exception {
		SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
		SOAPConnection soapc = soapcf.createConnection();

		MessageFactory mf = MessageFactory.newInstance();
		SOAPMessage soapm = mf.createMessage();
		    
		SOAPPart soapp = soapm.getSOAPPart();
		SOAPEnvelope soape = soapp.getEnvelope();
		SOAPBody soapb = soape.getBody();

		soape.getHeader().detachNode();
		
		QName name = new QName("http://custodian/", "RemoveStock");
		SOAPElement soapel = soapb.addBodyElement(name);

		soapel.addChildElement(
		    new QName("arg0")).addTextNode(stockId.toString());
		
		String endpoint = "http://127.0.0.1:8000/Custodian";
		
		SOAPMessage response = soapc.call(soapm, endpoint);
		soapc.close();
		
		SOAPBody responseBody = response.getSOAPBody();
		if (responseBody.hasFault()) {
		    System.out.println(responseBody.getFault().getFaultString()); 
		} else {
		    
			QName RemoveStockResponseName = new QName("http://custodian/", "RemoveStockResponse");
			QName returnName = new QName("return");
	
			SOAPBodyElement RemoveStockResponse = (SOAPBodyElement)
			       responseBody.getChildElements(RemoveStockResponseName).next();
			SOAPBodyElement res = (SOAPBodyElement)
					RemoveStockResponse.getChildElements(returnName).next();
	
			System.out.println(res.getValue());
			
		}
	}
}
