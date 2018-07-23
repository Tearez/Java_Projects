public class Example3 {
    public static void withdraw() throws Exception {
        int moneyInATM = 1000;
        int customerNeeds = 1500;

        try {
            checkATMHasEnoughMoney(moneyInATM, customerNeeds);
            moneyInATM -= customerNeeds;
            System.out.println("Successful Transaction");
        } catch (Exception ex) {
            System.err.println();
            throw new Exception("Transaction not successful. " + ex.getMessage());
        }
    }

    static void checkATMHasEnoughMoney(int moneyInATM, int customerNeeds) throws Exception {
        if (customerNeeds > moneyInATM) {
            throw new Exception("Not enough money in ATM");
        }
    }

    static void printMessage() {
        try {
            Example3.withdraw();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
