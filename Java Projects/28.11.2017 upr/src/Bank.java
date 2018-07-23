
public class Bank {
    private String nameOfBank;
    private String nameOfTown;
    private int bankID;

    public String getNameOfBank() {
        return nameOfBank;
    }

    public String getNameOfTown() {
        return nameOfTown;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }
    public void print(){
        System.out.println("Name of Bank = " + this.getNameOfBank()+ "Bank is in = " + this.getNameOfTown()+"Its ID is = " + this.getBankID());
    }
}
