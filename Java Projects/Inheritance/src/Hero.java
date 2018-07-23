import java.util.ArrayList;

public class Hero extends Person {
    private String secretIdentity;
    private String backStory;
    private boolean isGood;
    private ArrayList<Powers> listOfPowers = new ArrayList<>();

    public Hero() {

    }

    public Hero(String name, int weight, Gender gender, String secretIdentity, String backStory, boolean isGood, ArrayList<Powers> listOfPowers) {
        super(name, weight, gender);
        this.secretIdentity = secretIdentity;
        this.backStory = backStory;
        this.isGood = isGood;
        this.listOfPowers = listOfPowers;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public ArrayList<Powers> getListOfPowers() {
        return listOfPowers;
    }

    public void setListOfPowers(ArrayList<Powers> listOfPowers) {
        this.listOfPowers = listOfPowers;
    }

    public void addSuperPower(Powers powers){
        listOfPowers.add(powers);
    }

    public void canFly(){
        System.out.println("Probably Cannot");
    }
}
