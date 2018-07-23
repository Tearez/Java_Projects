public class Main {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0,}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(grid));
    }

    public static int findCircleNum(int[][] M){
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0){
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(m,visited,j);
            }
        }
    }
}
