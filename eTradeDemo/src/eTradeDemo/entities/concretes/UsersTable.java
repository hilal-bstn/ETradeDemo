package eTradeDemo.entities.concretes;


import java.util.ArrayList;
import java.util.List;

public class UsersTable {
	public List<User> users=new ArrayList<User>();
	
	public UsersTable() {
		User user1=new User(1,"Hilal","Baþtan","hilal@gmail.com","1234567");
		users.add(user1);
	}
}
