package eTradeDemo.business.concretes;

import eTradeDemo.business.abstracts.UserVerifyService;

public class UserEmailVerificationManager implements UserVerifyService {

	@Override
	public void Send() 
	{
		System.out.println("Kullanýcý doðrulama emaili gönderildi.");
	}

}
