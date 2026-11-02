package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;
import java.io.*;
import java.util.*;

public class TransactionRepo implements ITransactionRepo 
{
    public void withdraw(Transaction t)
	{
        AccountRepo arp = new AccountRepo();
        Account ac = arp.searchAccountByAccNo(t.getAccNo());

        if (ac != null && ac.getBalance() >= t.getAmount())
		{
            ac.setBalance(ac.getBalance() - t.getAmount());
            arp.updateAccount(ac);
            t.setBalance(ac.getBalance());
            this.addTransaction(t);
        }

    }
	
	public void deposit(Transaction t)
	{
        AccountRepo arp = new AccountRepo();
        Account ac = arp.searchAccountByAccNo(t.getAccNo());

        if (ac != null)
		{
            ac.setBalance(ac.getBalance() + t.getAmount());
            arp.updateAccount(ac);
            t.setBalance(ac.getBalance());
            this.addTransaction(t);
        }
    }

	public void addTransaction(Transaction t)
	{
        Transaction[] transactionList = this.getAllTransaction();

        for (int i = 0; i < transactionList.length; i++)
		{
            if (transactionList[i] == null)
			{
                transactionList[i] = t;
                break;
            }
        }
        this.write(transactionList);
    }


    public Transaction searchByTransactionId(String id) 
	{
        Transaction[] transactionList = this.getAllTransaction();

        for (Transaction t : transactionList) 
		{
            if (t != null && t.getTransactionId().equals(id)) 
			{
                return t;
            }
        }
        return null;
    }

	public String generateTransactionId(String transactionType)
	{
        String prefix = "TXDP";
        if (transactionType.equals("Withdraw"))
		{
            prefix = "TXWD";
        }

        Random random = new Random();
        String id = prefix + (100000000 + random.nextInt(900000000));
        while (this.searchByTransactionId(id) != null)
		{
            id = prefix + (100000000 + random.nextInt(900000000));
        }
        return id;
    }
public Transaction[] searchByAccNo(String accNo)
{
    Transaction[] transactionList = this.getAllTransaction();
    Transaction[] foundTransactions = new Transaction[transactionList.length];
    int index = 0;

    for (Transaction t : transactionList) 
    {
        if (t != null && t.getAccNo().equals(accNo)) 
        {
            foundTransactions[index] = t;
            index++;
        }
    }


    return foundTransactions;
}



    public Transaction[] getAllTransaction()
	{
        FileIO fio = new FileIO();
        String[] data = fio.readFile("repositories/data/transaction.txt");

        Transaction[] transactionList = new Transaction[1000];
        int i = 0;
        for (String str : data) {
            if (str != null && !str.trim().isEmpty()) {
                transactionList[i] = Transaction.formTransaction(str);
                i++;
            }
        }

        return transactionList;
    }
	


    public void write(Transaction[] transactionList) {
        String[] data = new String[1000];
        for (int i = 0; i < transactionList.length; i++) {
            if (transactionList[i] != null) {
                data[i] = transactionList[i].toStringTransaction();
            }
        }
        FileIO fio = new FileIO();
        fio.writeFile(data, "repositories/data/transaction.txt");
    }
}
