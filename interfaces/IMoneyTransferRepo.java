package interfaces;
import java.lang.*;
import entities.*;

public interface IMoneyTransferRepo
{
	void transfer(MoneyTransfer mt);
	MoneyTransfer searchByMoneyTransferId(String id);
	String generateMoneyTransferId();
	MoneyTransfer[] searchByAccNo(String accNo);
	MoneyTransfer[] getAllMoneyTransfer();
}