import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class CycleSearch {
    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static List<Integer> cycle;
    private static boolean dfs(int v) {
        visited[v] = true;
        for (int neighbor : graph[v]) {
            if (!visited[neighbor]) {
                parent[neighbor] = v;
                if (dfs(neighbor)) {
                    return true;
                }
            } else if (neighbor != parent[v]) {
                cycle = new ArrayList<>();
                cycle.add(neighbor);
                int current = v;
                while (current != neighbor) {
                    cycle.add(current);
                    current = parent[current];
                }
                cycle.add(neighbor);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine().trim());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            String[] line = reader.readLine().trim().split(" ");
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(line[j - 1]) == 1) {
                    graph[i].add(j);
                }
            }
        }
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    break;
                }
            }
        }
        if (cycle == null) {
            writer.write("NO\n");
        } else {
            writer.write("YES\n");
            writer.write(cycle.size() + "\n");
            Collections.reverse(cycle); // Обратим порядок для правильного вывода
            for (int vertex : cycle) {
                writer.write(vertex + " ");
            }
            writer.newLine();
        }
        writer.flush();
    }
}