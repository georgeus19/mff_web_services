package stockmarket;

import java.util.Arrays;

import javax.xml.ws.Endpoint;


public class Runner {

	public static void main(String[] args) {
		StockMarket amsterdamStockMarket = new StockMarketImpl(new StockList(
			Arrays.asList(
				new AvailableStock(new Stock(0, "Google", 2700), 200),
				new AvailableStock(new Stock(1, "NVidia", 365), 102),
				new AvailableStock(new Stock(2, "Microsoft", 300), 303),
				new AvailableStock(new Stock(3, "AMD", 500), 323),
				new AvailableStock(new Stock(4, "Tesla", 1200), 27)
			)
		));
		
		StockMarket londonStockMarket = new StockMarketImpl(new StockList(
				Arrays.asList(
						new AvailableStock(new Stock(0, "Google", 2800), 200),
						new AvailableStock(new Stock(1, "NVidia", 350), 195),
						new AvailableStock(new Stock(2, "Microsoft", 310), 254),
						new AvailableStock(new Stock(3, "AMD", 500), 322),
						new AvailableStock(new Stock(4, "Tesla", 1150), 291)
						)
				));
		Endpoint.publish("http://127.0.0.1:8000/StockMarket", amsterdamStockMarket);
		
		
		Endpoint.publish("http://127.0.0.1:8002/StockMarket", londonStockMarket);
	}
}
