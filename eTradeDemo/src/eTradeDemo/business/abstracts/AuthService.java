package eTradeDemo.business.abstracts;

import eTradeDemo.entities.concretes.User;

public interface AuthService 
{
	String register(User user);
	String login(String email,String password);
}
