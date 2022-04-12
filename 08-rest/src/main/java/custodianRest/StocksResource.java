package custodianRest;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/users")
public class StocksResource {
	private static Map<Integer, User> users = new HashMap<Integer, User>();
	
	public StocksResource() {}
	
	/*
	 * I updated the custodian service to have users which have stocks.
	 * I implemented GET, PUT, DELETE, POST for user collection and individual users.
	 * Collection of stocks and individual stocks are provided only through GET.
	 * 
	 * I created UserList wrapper for List<User> since receiving List<User> just does not work.
	 * All requests for simplicity in one class.
	 */
	
	/*
	 * API for collection of users. 
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserList getUsers() {
		List<User> returnedUsers = new ArrayList<User>();
		returnedUsers.addAll( users.values() );
		return new UserList(returnedUsers);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putUsers(JAXBElement<UserList> userListElem) {
		users = new HashMap<Integer, User>();
		System.out.println(userListElem.getValue());
		for (User user : userListElem.getValue().getUsers()) {
			System.out.println(user.getFirstname());
			users.put(Integer.valueOf((user).getID()), user);
		}
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteUsers() {
		users = new HashMap<Integer, User>();
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response postUsers() {
		return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
	}
	
	/*
	 * API for individual users.
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{user}")
	public Response getUser(@PathParam("user") String userID) {
		Integer id = Integer.parseInt(userID);
		User user = users.get(id);
		if (user != null) {
			return Response.status(Response.Status.OK).entity(user).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("<error>No user with given ID.</error>").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{user}")
	public Response putUser(@PathParam("user") String userID, JAXBElement<User> userElem) {
		User user = userElem.getValue();
		Integer id = Integer.parseInt(userID);
		if (!id.equals(user.getID())) {
			return Response.status(Response.Status.CONFLICT).entity("<error>User ids don't match.</error>").build();
		}
		if (users.containsKey(id)) {
			users.put(id, user);
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			users.put(id, user);
			return Response.status(Response.Status.CREATED).build();			
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{user}")
	public Response deleteUser(@PathParam("user") String userID) {
		
		Integer id = Integer.parseInt(userID);
		if (!users.containsKey(id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("<error>No user with given ID.</error>").build();
		}
		users.remove(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{user}")
	public Response postUser(@PathParam("user") String userID, JAXBElement<User> userElem) {
		User paramUser = userElem.getValue();
		
		Integer id = Integer.parseInt(userID);
		if (!users.containsKey(id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("<error>No user with given ID.</error>").build();
		}
		User user = users.get(id);
		if (paramUser.getFirstname() == null || paramUser.getFirstname().equals("") || paramUser.getSurname() == null || paramUser.getSurname().equals("")) {
			return Response.status(Response.Status.CONFLICT).entity("<error>Invalid values for firstname of surname.</error>").build();
		}
		user.setFirstname(paramUser.getFirstname());
		user.setSurname(paramUser.getSurname());
		users.put(id, user);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

	
	/*
	 * Get requests for stocks.
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{user}/stocks")
	public Response getUserStocks(@PathParam("user") String userID) {
		Integer id = Integer.parseInt(userID);
		if (!users.containsKey(id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("<error>User not found.</error>").build();
		}
		User user = users.get(id);
		return Response.status(Response.Status.OK).entity(user.getStocks()).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{user}/stocks/{company}")
	public Response getUserStock(@PathParam("user") String userID, @PathParam("company") String company) {
		Integer id = Integer.parseInt(userID);
		if (!users.containsKey(id)) {
			return Response.status(Response.Status.NOT_FOUND).entity("<error>User not found.</error>").build();
		}
		User user = users.get(id);
		Stock stock = user.FindStock(company);
		if (stock != null) {
			return Response.status(Response.Status.OK).entity(stock).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("<error>Stock not found.</error>").build();
		}
	}

}
