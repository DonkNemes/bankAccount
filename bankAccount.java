class bankAccount {
  private int minBalance = -1000; // overdraft
  private int balance = 1000;
  private double interestRate = 0.05;
  private String name;

  public bankAccount(String name) {
    this.name = name;
  }

  public void setBalance(int balance) {
    this.balance = balance;
    System.out.println("Your current balance after the operation is $" + balance);
  }

  public int getBalance() {
    return balance;
  }

  public String withdrawBalance(int num) {
    if (this.balance - num < minBalance) { // checks if you can withdraw a certain amount
      return "Withdrawal denied. Insufficient funds. Overdraft limit is $" + minBalance + ".";
    }
    this.balance -= num;
    return "You've withdrawn $" + num + ". Your current balance is $" + this.balance + ".";
  }

  public String depositBalance(int num) {
    this.balance += num;
    return "You've deposited $" + num + ". Your current balance is $" + this.balance + ".";
  }

  public boolean isOverdrawn() {
    return this.balance < 0;
  }

  public String checkOverdrawnStatus() {
    if (isOverdrawn()) {
      return "Your account is overdrawn!";
    } else {
      return "Your account is in good standing.";
    }
  }

  public String addInterest() {
    if (balance > 0) {
      double interest = balance * interestRate;
      balance += (int) interest;
      return "Interest of $" + (int) interest + " has been added. Your new balance is $" + balance + ".";
    } else {
      return "No interest is added to overdrawn or zero-balance accounts.";
    }
  }

  public String transferFunds(bankAccount otherAccount, int amount) {
    if (this.balance - amount < minBalance) {
      return "Transfer denied. Not enough funds in the account balance.";
    }
    this.balance -= amount;
    otherAccount.balance += amount;
    return "You have transferred $" + amount + " to the other account. Your current balance is $" + this.balance + ".";
  }
}
