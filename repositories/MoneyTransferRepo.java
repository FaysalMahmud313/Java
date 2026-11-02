package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class MoneyTransferRepo implements IMoneyTransferRepo
{
	public void transfer(MoneyTransfer mt)
	{
		AccountRepo arp=new AccountRepo();
        MoneyTransfer[] moneyTransferList = this.getAllMoneyTransfer();
        Account fromAccount = arp.searchAccountByAccNo(mt.getSenderAccNo());
        Account toAccount = arp.searchAccountByAccNo(mt.getReceiverAccNo());

        if(fromAccount!=null && toAccount!=null)
		{

			if (fromAccount.getBalance() >= mt.getAmount())
			{
				fromAccount.setBalance(fromAccount.getBalance() - mt.getAmount());
				arp.updateAccount(fromAccount);

				toAccount.setBalance(toAccount.getBalance() + mt.getAmount());
				arp.updateAccount(toAccount);

				for(int i=0;i<moneyTransferList.length;i++)
				{
					if(moneyTransferList[i]==null)
					{
						moneyTransferList[i]=mt;
						break;
					}
				}
				this.write(moneyTransferList);
			}

			else
			{
				System.out.println("Insufficient funds for transfer.");
			}
		}
		else
		{
			System.out.println("One or both accounts not found.");
		}
    }
	public String generateMoneyTransferId()
	{
		Random random=new Random();
		String id="TXTR"+(100000000+random.nextInt(900000000));
		while(this.searchByMoneyTransferId(id)!=null)
		{
			id="TXTR"+(100000000+random.nextInt(900000000));
		}
		return id;
	}
	public MoneyTransfer searchByMoneyTransferId(String id)
	{
		MoneyTransfer[] moneyTransferList=this.getAllMoneyTransfer();
		
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				if(moneyTransferList[i].getMoneyTransferId().equals(id))
				{
					return moneyTransferList[i];
				}
			}
			
		}

		return null;
	}
	
	public MoneyTransfer[] searchByAccNo(String accNo)
	{
		MoneyTransfer[] moneyTransferList=this.getAllMoneyTransfer();
		MoneyTransfer[] foundTransaction=new MoneyTransfer[moneyTransferList.length];
		int index=0;

		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				if(moneyTransferList[i].getSenderAccNo().equals(accNo))
				{
					foundTransaction[index]=moneyTransferList[i];
					index++;
				}
				else if(moneyTransferList[i].getReceiverAccNo().equals(accNo))
				{
					foundTransaction[index]=moneyTransferList[i];
					index++;
				}
			}

		}

		return foundTransaction;
	}
	public MoneyTransfer[] getAllMoneyTransfer() 
	{
        FileIO fio = new FileIO();
        String[] data = fio.readFile("repositories/data/moneytransfer.txt");
		MoneyTransfer mt=new MoneyTransfer();
        MoneyTransfer[] moneyTransferList = new MoneyTransfer[1000];
        int i = 0;
        for (String str : data) 
		{
            if (str != null && !str.trim().isEmpty())
			{
               moneyTransferList[i]=mt.formMoneyTransfer(str);
               i++;
            }
        }

        return moneyTransferList;
    }
	public void write(MoneyTransfer[] moneyTransferList) 
	{
        String[] data = new String[1000];
        for (int i = 0; i < moneyTransferList.length; i++) 
		{
            if (moneyTransferList[i] != null) 
			{
                data[i] = moneyTransferList[i].toStringMoneyTransfer();
            }
        }
        FileIO fio = new FileIO();
        fio.writeFile(data, "repositories/data/moneytransfer.txt");
    }
} 