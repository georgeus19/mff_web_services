package custodianRest;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int ID;
	private String firstname;
	private String surname;
	private List<Stock> stocks;
	
	public User() {}
	
	public User(int id, String fn, String sn, List<Stock> s) {
		ID = id;
		firstname = fn;
		surname = sn;
		stocks = s;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public Stock FindStock(String company) {
		for (Stock stock : stocks) {
			if (stock.getCompany().equals(company)) {
				return stock;
			}
		}
		return null;
	}

}
