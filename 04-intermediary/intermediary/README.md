# Normal
- Client sends request to stock market to buy a number of stocks (provides stockId and count).
- Stock market sells the stocks if available and returns the price of the bought stocks and some additional info.
# With intermediary
- Client sends request to the intermediary with additional header `<scam increasePriceBy="420" xmlns="http://scam.com/"/>`
- Intermediary stores `increasePriceBy` and forwards the request to stock market.
- Intermediary receives response from stock market and adds `increacePriceBy` to `<price>` element.
- Intermediary also parses `count` element from response and returns header `<scammed xmlns="http://scams.com/">Scammed for {increasePriceBy * count} dollars :)</scammed>`.

Examples of modified headers below (original NVidia stock price is `365`).

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:stoc="http://stockmarket/">
   <soapenv:Header>
   	<scam increasePriceBy="420" xmlns="http://scam.com/"/>
   </soapenv:Header>
   <soapenv:Body>
      <stoc:BuyStocks>
         <arg0>1</arg0>
         <arg1>2</arg1>
      </stoc:BuyStocks>
   </soapenv:Body>
</soapenv:Envelope>
```

```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Header>
      <scammed xmlns="http://scams.com/">Scammed for 840.0 dollars :)</scammed>
   </S:Header>
   <S:Body>
      <ns2:BuyStocksResponse xmlns:ns2="http://stockmarket/">
         <return>
            <count>2</count>
            <stock>
               <id>1</id>
               <name>NVidia</name>
               <price>785.0</price>
            </stock>
         </return>
      </ns2:BuyStocksResponse>
   </S:Body>
</S:Envelope>
```

