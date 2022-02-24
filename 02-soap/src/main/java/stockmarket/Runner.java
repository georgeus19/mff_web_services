package stockmarket;

import java.util.Arrays;

import javax.xml.ws.Endpoint;


public class Runner {

	public static void main(String[] args) {
		StockMarket stockMarket = new StockMarketImpl(new StockList(
			Arrays.asList(
				new AvailableStock(new Stock(0, "Google", 2700), 4),
				new AvailableStock(new Stock(1, "NVidia", 365), 10),
				new AvailableStock(new Stock(2, "Microsoft", 300), 3),
				new AvailableStock(new Stock(3, "AMD", 500), 32),
				new AvailableStock(new Stock(4, "Tesla", 1200), 2)
			)
		));
		
		Endpoint.publish("http://127.0.0.1:8000/StockMarket", stockMarket);
	}
}
