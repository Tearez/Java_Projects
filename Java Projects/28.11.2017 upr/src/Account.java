import jdk.nashorn.internal.objects.annotations.Constructor;

public class Account {
    private int accNumber;
    private int Cash;
    private String Bank;

    public Account(int accNumber, int cash, String bank) {
        this.accNumber = accNumber;
        this.Cash = cash;
        this.Bank = bank;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public String getBank() {
        return Bank;
    }

    protected int getCash() {
        return this.Cash;
    }

    protected void changeAmount(int amount) {
        this.Cash = this.Cash + amount;
    }

    protected void addMoney(int amount) {
        if (amount > 0) {
            changeAmount(amount);
        } else {
            System.err.println("Cannot add less than 1");
        }
    }

    protected void reduceMoney(int amount) {
        if ((this.Cash - amount) >= 0) {
            changeAmount(0 - amount);
        } else {
            System.err.println("Cannot take so much");
        }
    }
}
