public class vipAccount extends Account{

    public vipAccount(int accNumber, int cash, String bank) {
        super(accNumber, cash, bank);
    }

    @Override
    protected void reduceMoney(int amount) {
        changeAmount(amount);
    }
}
