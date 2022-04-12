package custodianRest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stock {
	private String company;
	private int count;
	
	public Stock() {}

	public Stock(String comp, int c) {
		company = comp;
		count = c;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String c) {
		company = c;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
