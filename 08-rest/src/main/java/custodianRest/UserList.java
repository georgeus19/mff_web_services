package custodianRest;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserList {
	private List<User> users;

	public UserList(List<User> u) {
		setUsers(u);
	}

	public UserList() {
		setUsers(new ArrayList<User>());
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
