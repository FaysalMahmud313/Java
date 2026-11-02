package interfaces;
import java.lang.*;
import entities.*;

public interface IAccountRepo
{
	
	void createAccount(Account ac);
	void removeAccount(String key);
	Account searchAccountByUserId(String id);
	Account searchAccountByAccNo(String accNo);
	String generateAccNo();
	double checkBalance(String userId);
	Account[] getAllAccount();
	
}