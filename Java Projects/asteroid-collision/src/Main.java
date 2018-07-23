import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Arrays.stream(asteroidCollision(new int[]{5, 10, -5}))
                .forEach(System.out::println);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> asteroidsList = new LinkedList<>();
        for (int asteroid : asteroids) {
            asteroidsList.addLast(asteroid);
            if (asteroid < 0) {
                while (asteroidsList.size() > 1) {
                    int right = asteroidsList.removeLast();
                    int left = asteroidsList.removeLast();
                    if (left > 0 && right < 0) {
                        if (left < -1 * right) {
                            asteroidsList.addLast(right);
                        }
                        if (left > -1 * right){
                            asteroidsList.addLast(left);
                        }
                    } else {
                        asteroidsList.addLast(left);
                        asteroidsList.addLast(right);
                        break;
                    }
                }
            }
        }

        int[] result = new int[asteroidsList.size()];
        for (int i = 0; i<result.length; i++) {
            result[i] = asteroidsList.removeFirst();
        }

        return result;
    }
}
