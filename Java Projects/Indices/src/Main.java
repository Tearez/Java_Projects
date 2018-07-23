import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SuperHero batman = new SuperHero("Batman", "Bruce Wayne", Alignment.Neutral);
        Power kryptonite = new Power("Kryptonite", PowerType.Chemical);
        batman.addHeroPowers(kryptonite);

        SuperHero superman = new SuperHero("SuperMan", "Clark Cent", Alignment.Good);
        ArrayList<PowerType> superManImmunities = new ArrayList<>();
        superManImmunities.add(PowerType.Magic);
        superManImmunities.add(PowerType.Intellect);
        superManImmunities.add(PowerType.Tech);

        superman.setImmunities(superManImmunities);
        batman.getHeroPowers().forEach(System.out::println);

        batman.attack(superman, kryptonite);
    }
}
