package eTradeDemo;

import eTradeDemo.business.abstracts.AuthService;
import eTradeDemo.business.concretes.AuthManager;
import eTradeDemo.business.concretes.UserEmailVerificationManager;
import eTradeDemo.core.GoogleAuthManagerAdepter;
import eTradeDemo.dataAccess.concretes.InMemoryUserDao;
import eTradeDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		AuthService authService=new AuthManager(new InMemoryUserDao(),new UserEmailVerificationManager());
		User user =new User(2,"Hilal","Baþtan","hilal10@gmail.com","1234568" );
		String message=authService.register(user);
		System.out.println(message);
		
		GoogleAuthManagerAdepter googleAuthManagerAdapter=new GoogleAuthManagerAdepter();
		googleAuthManagerAdapter.register();
		String loginMessage=authService.login("hilal@gmail.com", "1234567");
		System.out.println(loginMessage);

	}

}
