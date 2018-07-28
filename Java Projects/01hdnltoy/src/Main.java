import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static void fakeInput() {
        String test = "4\n" +
            "h1\n" +
            "r5\n" +
            "d2\n" +
            "a0\n" +
            "9\n" +
            "a1\n" +
            "b2\n" +
            "c3\n" +
            "d3\n" +
            "e2\n" +
            "f3\n" +
            "g2\n" +
            "h1\n" +
            "i2";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        solve(in);
        System.out.println(" -------------- ");
        solve(in);
    }

    private static void solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Stack<Tag> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String tagString = in.nextLine();
            char name = tagString.charAt(0);
            int level = Integer.parseInt(tagString.substring(1));
            while (!stack.empty() && stack.peek().level >= level) {
                Tag tag = stack.pop();
                int countOfSpaces = tag.getParentsCount();
                String offset = repeat(' ', countOfSpaces);
                System.out.println(offset + "</" + tag + ">");
            }

            int parentsCount = 0;
            if (!stack.empty()) {
                parentsCount = stack.peek().getParentsCount() + 1;
            }

            String offset = repeat(' ', parentsCount);
            Tag newTag = new Tag(name, level, parentsCount);
            System.out.println(offset + "<" + newTag + ">");
            stack.push(newTag);
        }

        while (!stack.empty()) {
            Tag tag = stack.pop();
            int countOfSpaces = tag.getParentsCount();
            String offset = repeat(' ', countOfSpaces);
            System.out.println(offset + "</" + tag + ">");
        }
    }

    private static String repeat(char ch, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }

    static class Tag {
        private char name;
        private int level;
        private int parentsCount;

        public Tag(char name, int level) {
            this(name, level, 0);
        }

        public Tag(char name, int level, int parentsCount) {

            this.name = name;
            this.level = level;
            this.parentsCount = parentsCount;
        }

        public char getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return String.format("%c%d", getName(), getLevel());
        }

        public int getParentsCount() {
            return parentsCount;
        }
    }
}
