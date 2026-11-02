package entities;
import java.lang.*;

public class MoneyTransfer extends Account
{
	private String moneyTransferId, senderAccNo, receiverAccNo, date;
	private double  amount;
	
	public MoneyTransfer()
	{
		super();
	}
	public MoneyTransfer(String moneyTransferId,String senderAccNo,String receiverAccNo, double amount)
	{
		this.moneyTransferId=moneyTransferId;
		this.senderAccNo=senderAccNo;
		this.receiverAccNo=receiverAccNo;
		this.amount=amount;
	}
	public MoneyTransfer(String moneyTransferId,String senderAccNo,String receiverAccNo, double amount,String date)
	{
		this.moneyTransferId=moneyTransferId;
		this.senderAccNo=senderAccNo;
		this.receiverAccNo=receiverAccNo;
		this.amount=amount;
		this.date=date;
	}
	public void setMoneyTransferId(String moneyTransferId)
	{
		this.moneyTransferId=moneyTransferId;
	}
	public void setSenderAccNo(String senderAccNo)
	{
		this.senderAccNo=senderAccNo;
	}
	public void setReceiverAccNo(String receiverAccNo)
	{
		this.receiverAccNo=receiverAccNo;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public String getDate()
	{
		return this.date;
	}
	public String getMoneyTransferId()
	{
		return this.moneyTransferId;
	}
	public String getSenderAccNo()
	{
		return this.senderAccNo;
	}
	public String getReceiverAccNo()
	{
		return this.receiverAccNo;
	}
	public double getAmount()
	{
		return this.amount;
	}
	public String toStringMoneyTransfer()
	{
		String str=this.moneyTransferId+","+this.senderAccNo+","+this.receiverAccNo+","+this.amount+","+this.date+"\n";
		return str;
	}
	public MoneyTransfer formMoneyTransfer(String str)
	{
		String [] info=str.split(",");
		MoneyTransfer mt= new MoneyTransfer();
		mt.setMoneyTransferId(info[0]);
		mt.setSenderAccNo(info[1]);
		mt.setReceiverAccNo(info[2]);
		mt.setAmount(Double.parseDouble(info[3]));
		if(info.length>4)
		{
			mt.setDate(info[4]);
		}
		else
		{
			mt.setDate("");
		}
		return mt;
	}
	
}