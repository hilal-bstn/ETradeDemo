package eTradeDemo.core;

import eTradeDemo.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdepter implements AuthService {

	@Override
	public void register() {
		GoogleAuthManager googleAuthManager=new GoogleAuthManager();
		googleAuthManager.register();
	}

}
