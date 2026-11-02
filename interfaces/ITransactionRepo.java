package interfaces;
import java.lang.*;
import entities.*;

public interface ITransactionRepo
{
	void withdraw(Transaction t);
	void deposit(Transaction t);
	Transaction searchByTransactionId(String id);
	String generateTransactionId(String transactionType);
	Transaction[] searchByAccNo(String accNo);
	Transaction[] getAllTransaction();
	
}