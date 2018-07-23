public class Main {

    public static void main(String[] args) {
        SuperHero batman = new SuperHero();
        Powers isRich = new Powers("Is Rich", PowerType.Money);
        batman.addSuperPower(isRich);

    }
}
