package model.entities;

import model.exceptions.AccountException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	//getters
	
	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	//setters
	
	public void setNumber(Integer number) {
		this.number = number;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	//other methods
	
	public void deposit(Double amount) {
		this.balance+= amount;
	}
	
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		this.balance-= amount;
	}
	
	private void validateWithdraw(Double amount) {
		if(amount > getWithdrawLimit()) throw new AccountException("The amount exceeds withdraw limit !");
		if(amount > getBalance()) throw new AccountException("insufficient balance !");
	}
	
	@Override
	public String toString() {
		return "Account : \n"
			+ "number: "
			+ number
			+ "\n"
			+ "holder : "
			+ holder
			+ "\n"
			+ "balance : "
			+ String.format("%.2f", balance);
	}
	
}
