import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] sizes = in.nextLine().split(" ");
        String[] arr1 = in.nextLine().split(" ");
        String[] arr2 = in.nextLine().split(" ");
        ArrayList<Integer> firstArray = new ArrayList<>();
        ArrayList<Integer> secondArray = new ArrayList<>();
        parseElement(firstArray, arr1);
        parseElement(secondArray, arr2);

        if (firstArray.size() >= secondArray.size()) {
            sumElements(firstArray, secondArray);
            biggerThan10(firstArray);
            Printer(firstArray);
        } else if (firstArray.size() < secondArray.size()) {
            sumElements(secondArray, firstArray);
            biggerThan10(secondArray);
            Printer(secondArray);
        }
    }

    static void Printer(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            if (i!=array.size()-1){
                System.out.print(array.get(i)+ " ");
            }
            else{
                System.out.print(array.get(i));
            }
        }
    }
    static void biggerThan10(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 9) {
                array.set(i, array.get(i) % 10);
                array.set(i + 1, array.get(i + 1) + 1);
            }
        }
    }

    static void sumElements(ArrayList<Integer> biggerArray, ArrayList<Integer> smallerArray) {
        for (int i = 0; i < smallerArray.size(); i++) {
            biggerArray.set(i, (smallerArray.get(i) + biggerArray.get(i)));
        }
    }

    static void parseElement(ArrayList<Integer> numbers, String[] string) {
        for (int i = 0; i < string.length; i++) {
            numbers.add(Integer.parseInt(string[i]));
        }
    }
}
