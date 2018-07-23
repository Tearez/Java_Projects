import java.util.ArrayList;

public class SuperVillain extends Hero {
    private boolean wantsToKillEveryOne;

    public SuperVillain(String name, int weight, Gender gender, String secretIdentity, String backStory, boolean isGood,
                         ArrayList<Powers> listOfPowers, boolean wantsToKillEveryOne) {

        super(name, weight, gender, secretIdentity, backStory, isGood, listOfPowers);
        this.wantsToKillEveryOne = wantsToKillEveryOne;
    }

    public void destroy(){

    }

    @Override
    public void addSuperPower(Powers powers) {
        System.out.println(powers.toString());
    }

    @Override
    public void canFly() {
        System.out.println("He doesn't need it");
    }
}
