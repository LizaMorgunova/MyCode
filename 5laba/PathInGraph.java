import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PathInGraph {
    static int N;
    static List<Integer>[] graph;
    private static int[] bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                return reconstructPath(start, end, parent);
            }
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current; // Запоминаем предка
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }
    private static int[] reconstructPath(int start, int end, int[] parent) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path); // Обратим порядок пути
        return path.stream().mapToInt(i -> i).toArray(); // Преобразуем в массив
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine().trim());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            String[] line = reader.readLine().trim().split(" ");
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(line[j - 1]) == 1) {
                    graph[i].add(j);
                }
            }
        }
        String[] input = reader.readLine().trim().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int[] result = bfs(start, end);
        if (result == null) {
            writer.write("-1\n");
        } else {
            writer.write((result.length - 1) + "\n"); // Длина пути
            for (int vertex : result) {
                writer.write(vertex + " ");
            }
            writer.newLine();
        }
        writer.flush();
    }
}