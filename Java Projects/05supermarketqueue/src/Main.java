import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    Solution.start();

    }

    static class Solution {
        static InputReader reader = new InputReader();
        static OutputWriter writer = new OutputWriter();
        static ArrayList<String> people = new ArrayList<>();
        static HashMap<String, Integer> numberOfPeople = new HashMap<>();

        public static void start() {
            while (true) {
                String[] commands = reader.readLine().split(" ");
                switch (commands[0]) {
                    case "Append":
                        appendQueue(commands[1]);
                        break;
                    case "Insert":
                        insertAtposition(Integer.parseInt(commands[1]), commands[2]);
                        break;
                    case "Find":
                        findPeople(commands[1]);
                        break;
                    case "Serve":
                        servePeople(Integer.parseInt(commands[1]));
                        break;
                    case "End":
                        writer.close();
                        return;
                }
            }
        }

        static void appendQueue(String name) {
            people.add(people.size(),name);
            if (!numberOfPeople.containsKey(name)) {
                numberOfPeople.put(name, 1);
            } else {
                int value = numberOfPeople.get(name);
                value++;
                numberOfPeople.put(name, value);
            }
            writer.printLine("OK");
        }

        static void insertAtposition(int position, String name) {
            if (position < 0 || position > people.size()) {
                writer.printLine("Error");
            } else {
                people.add(position, name);
                if (!numberOfPeople.containsKey(name)) {
                    numberOfPeople.put(name, 1);
                } else {
                    int value = numberOfPeople.get(name);
                    value++;
                    numberOfPeople.put(name, value);
                }
                writer.printLine("OK");
            }
        }
        static void findPeople(String name){
            writer.printLine(numberOfPeople.getOrDefault(name, 0));
        }
        static void servePeople(int count){

            if (count<0 || count> people.size()){
                writer.printLine("Error");
            } else {
                List<String> served = people.subList(0, count);
                String resultNames = served.toString().replaceAll("[\\]\\[,]", "");
                writer.printLine(resultNames);
                served.clear();
                for (String names: resultNames.split(" ")) {
                    if (numberOfPeople.containsKey(names) && numberOfPeople.get(names) > 0) {
                        numberOfPeople.put(names, numberOfPeople.get(names) - 1);
                        if (numberOfPeople.get(names) == 0) {
                            numberOfPeople.remove(names);
                        }
                    }
                }
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}
