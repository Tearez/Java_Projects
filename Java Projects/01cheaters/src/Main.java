import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static LinkedList<String> list;
    static boolean samePriority = false;

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        int N = reader.readInt();
        HashMap<String, Integer> listOfNames = new HashMap<>();
        HashMap<String, Graph> subjects = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            String personX = input[0];
            String personY = input[1];
            String subject = input[2];
            if (!listOfNames.containsKey(personX)) {
                counter++;
                listOfNames.put(personX, counter);
            }
            if (!listOfNames.containsKey(personY)) {
                counter++;
                listOfNames.put(personY, counter);
            }
            if (!subjects.containsKey(subject)) {
                subjects.put(subject, new Graph(N));
            }
            subjects.get(subject).addEdge(listOfNames.get(personX), listOfNames.get(personY));
        }

        int M = reader.readInt();
        for (int i = 0; i < M; i++) {
            String[] input = reader.readLine().split(" ");
            String person = input[0];
            String subject = input[1];
            list = new LinkedList<>();
            samePriority = false;
            subjects.get(subject).DFS(listOfNames.get(person), listOfNames);
            if (samePriority) {
                list.sort(Collections.reverseOrder());
                writer.printLine(list.stream().collect(Collectors.joining(", ")));

            }
            else {
                writer.printLine(Stream.generate(list.descendingIterator()::next).limit(list.size()).collect(Collectors.joining(", ")));
            }
        }

        writer.close();
    }

    static class Graph {
        private int V;
        private ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<>());
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        public static String getKeyFromValue(Map<String, Integer> hm, Object value) {
            for (String o : hm.keySet()) {
                if (hm.get(o).equals(value)) {
                    return o;
                }
            }
            return "";
        }


        void DFSUtil(int v, boolean visited[], HashMap<String, Integer> map) {
            visited[v] = true;
            list.add(getKeyFromValue(map, v));
            if (samePriority || adj.get(v).size() > 1 ) {
                samePriority = true;
            }
            for (Integer n : adj.get(v)) {
                if (!visited[n])
                    DFSUtil(n, visited, map);
            }
        }


        void DFS(int v, HashMap<String, Integer> map) {
            boolean visited[] = new boolean[V];
            DFSUtil(v, visited, map);
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
