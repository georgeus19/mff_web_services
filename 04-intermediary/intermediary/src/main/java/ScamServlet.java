

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 * Servlet implementation class ScamServlet
 */
@WebServlet("/ScamServlet")
public class ScamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
			SOAPConnection soapc = soapcf.createConnection();
			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage soapm = mf.createMessage(null, request.getInputStream());
			SOAPHeader header = soapm.getSOAPHeader();
			
			Iterator it = header.examineAllHeaderElements();
			SOAPHeaderElement scamHeader = (SOAPHeaderElement)it.next();	
			
			Float increasePriceBy = Float.parseFloat(scamHeader.getAttribute("increasePriceBy"));
			
			String endpoint = "http://127.0.0.1:8000/StockMarket";
			SOAPMessage originalResponse = soapc.call(soapm, endpoint);

			SOAPHeader soaph = originalResponse.getSOAPPart().getEnvelope().addHeader();
			
			QName scammed = new QName("http://scams.com/", "scammed");
			SOAPHeaderElement scammedHeader = soaph.addHeaderElement(scammed);
			
			SOAPBody responseBody = originalResponse.getSOAPBody();
			
			QName BuyStocksResponseName = new QName("http://stockmarket/", "BuyStocksResponse");
			QName returnName = new QName("return");
			QName stockName = new QName("stock");
			QName priceName = new QName("price");
			QName countName = new QName("count");
			
			SOAPBodyElement BuyStocksResponseElement = (SOAPBodyElement)
			       responseBody.getChildElements(BuyStocksResponseName).next();
			SOAPBodyElement returnElement = (SOAPBodyElement)
					BuyStocksResponseElement.getChildElements(returnName).next();
			SOAPBodyElement stockElement = (SOAPBodyElement)
					returnElement.getChildElements(stockName).next();
			SOAPBodyElement priceElement = (SOAPBodyElement)
					stockElement.getChildElements(priceName).next();
			
			SOAPBodyElement countElement = (SOAPBodyElement)
					returnElement.getChildElements(countName).next();
			
			Integer count = Integer.parseInt(countElement.getValue());
				
				
			Float price = Float.parseFloat(priceElement.getValue());
			priceElement.setValue(Float.valueOf(price + increasePriceBy).toString());

			scammedHeader.setValue("Scammed for " + Float.valueOf(increasePriceBy * count).toString() + " dollars :)");
			
			originalResponse.writeTo(response.getOutputStream());
			
		} catch (Exception e){
			System.out.println("Exception triggered:" + e); 
		}
	}
}
