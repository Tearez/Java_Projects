import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String PN;
    private ArrayList<Account> accounts;

    public Customer(){
        this.accounts = new ArrayList<>();
    }
    public void addAccount(int accNumber, int cash, String bank){
        this.accounts.add(new Account(accNumber, cash, bank));
    }
    public void removeAccount(int accNumber){
        for(int i=accounts.size()-1; i==0;i--){
            if (accounts.get(i).getAccNumber()==accNumber){
                accounts.remove(i);
                break;
            }
        }
    }

}
