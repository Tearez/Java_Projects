import java.util.ArrayList;

public class SuperHero extends Hero {
    private ArrayList<Hero> enemies;

    public SuperHero(){}

    public SuperHero(String name, int weight, Gender gender, String secretIdentity, String backStory, boolean isGood,
                     ArrayList<Powers> listOfPowers, ArrayList<Hero> enemies) {
        super(name, weight, gender, secretIdentity, backStory, isGood, listOfPowers);
        this.enemies = enemies;
    }

    public void setEnemies(Hero hero) {
        this.enemies.add(hero);
    }

    public void saveWorld(){

    }

    @Override
    public void addSuperPower(Powers powers) {
        System.out.print(powers.toString());
    }

    @Override
    public void canFly() {
        System.out.println("Probably Can");
    }
}
