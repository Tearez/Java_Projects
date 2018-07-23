import java.util.ArrayList;

public class SuperHero {
    private String heroName;
    private String heroSecret;
    private Alignment heroAlignment;
    private int heroHitPoints;
    private ArrayList<PowerType> Immunities = new ArrayList<>();
    private ArrayList<Power> heroPowers = new ArrayList<>();

    public SuperHero(String heroName, String heroSecret, Alignment heroAlignment) {
        if (heroName.length() > 60) {
            this.heroName = heroName.substring(0, 60);
        } else {
            this.heroName = heroName;
        }

        if (heroSecret.length() > 60) {
            this.heroSecret = heroSecret.substring(0, 60);
        } else {
            this.heroSecret = heroSecret;
        }
        this.heroAlignment = heroAlignment;
        this.heroHitPoints = 100;
    }

    // Getters for Super Heroes

    public String getHeroName() {
        return heroName;
    }

    public String getHeroSecret() {
        return heroSecret;
    }

    public Alignment getHeroAlignment() {
        return heroAlignment;
    }

    public int getHeroHitPoints() {
        return heroHitPoints;
    }

    public ArrayList<PowerType> getImmunities() {
        return Immunities;
    }

    public ArrayList<Power> getHeroPowers() {
        return heroPowers;
    }

    //Setters for Super Heroes

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setHeroSecret(String heroSecret) {
        this.heroSecret = heroSecret;
    }

    public void setHeroAlignment(Alignment heroAlignment) {
        this.heroAlignment = heroAlignment;
    }

    public void setHeroHitPoints(int heroHitPoints) {
        this.heroHitPoints = heroHitPoints;
    }

    public void setImmunities(ArrayList<PowerType> immunities) {
        for (int i = 0; i < immunities.size(); i++) {
            Immunities.add(immunities.get(i));
        }
    }

    public void setHeroPowers(ArrayList<Power> heroPowers) {
        for (int i = 0; i < heroPowers.size(); i++) {
            this.heroPowers.add(heroPowers.get(i));
        }
    }

    public void addImmunities(PowerType immunities) {
        Immunities.add(immunities);
    }

    public void addHeroPowers(Power heroPowers) {
        this.heroPowers.add(heroPowers);
    }

    //Attacking another super hero

    public void attack(SuperHero superHero, Power power) {
        for (Power heroPower : this.heroPowers) {
            if (superHero.getImmunities().contains(heroPower.getPowerType())) {
                System.out.println(this.heroName + "'s attack is not very effective");
                return;
            }
        }
        System.out.println(this.heroName + "'s attack was successful");
        superHero.setHeroHitPoints(superHero.getHeroHitPoints() - 10);
    }

}
