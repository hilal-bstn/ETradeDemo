package eTradeDemo.business.concretes;

import eTradeDemo.business.abstracts.UserVerifyService;

public class UserEmailVerificationManager implements UserVerifyService {

	@Override
	public void Send() 
	{
		System.out.println("Kullan�c� do�rulama emaili g�nderildi.");
	}

}
