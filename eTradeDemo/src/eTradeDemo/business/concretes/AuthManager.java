package eTradeDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTradeDemo.business.abstracts.AuthService;
import eTradeDemo.business.abstracts.UserVerifyService;
import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;
import eTradeDemo.entities.concretes.UsersTable;

public class AuthManager implements AuthService {
	UserDao userDao;
	UserVerifyService userVerifyService;
	public AuthManager(UserDao userDao,UserVerifyService userVerifyService) 
	{
		super();
		this.userDao = userDao;
		this.userVerifyService=userVerifyService;
		
	}
	@Override
	public String register(User user) 
	{   String message;
		if(checkUserIsEmpty(user)&&checkPassword(user)&&checkFirstNameandLastName(user)&&checkEmail(user)&&checkUserEmail(user))
		{  
			userVerifyService.Send();
			userDao.Add(user);
            message="Kullanıcı kaydı başarıyla tamamlanmıştır.";
		}
		else
		{
			message="Lütfen girdiğiniz bilgileri kontrol ediniz.";


		}
		return message;
	}
	private boolean checkUserIsEmpty(User user)
	{
		if(user.getEmail().isEmpty()||user.getLastName().isEmpty()||user.getEmail().isEmpty()
				||user.getPassword().isEmpty())
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	private boolean checkPassword(User user)
	{
		if(user.getPassword().length()>=6)
			{
				return true;
			}
		else 
		{
			return false;
		}
	}
	private boolean checkFirstNameandLastName(User user)
	{
		if(user.getFirstName().length()>=2||user.getLastName().length()>=2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	private boolean checkEmail(User user)
	{
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        if (!matcher.matches()) 
        {
            return false;
        }
        else
        {
        	return true;
        }
	}
	private boolean checkUserEmail(User user)
	{
		UsersTable usersTable=new UsersTable();
		for(User u:usersTable.users)
		{
			if(u.getEmail()==user.getEmail())
			{
				return false;
			}
		}
		return true;
	}
	@Override
	public String login(String email, String password) {
		UsersTable usersTable=new UsersTable();
		String message="Girdiğiniz bilgilerde hata var.";
		for(User u:usersTable.users)
		{
			if(u.getEmail()==email&&u.getPassword()==password)
			{
				message="Giriş başarılı";
				break;
			}
		}
		return message;
	}
	
}
