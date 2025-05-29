import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class ConnectedComponents {
    private List<List<Integer>> graph;
    private boolean[] visited;
    public ConnectedComponents(int n) {
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
    }
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    public List<List<Integer>> findConnectedComponents() {
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }
        return components;
    }
    private void dfs(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLine = reader.readLine().split(" ");
        int ver = Integer.parseInt(firstLine[0]);
        int edges = Integer.parseInt(firstLine[1]);
        ConnectedComponents cc = new ConnectedComponents(ver);
        for (int i = 0; i < edges; i++) {
            String[] edge = reader.readLine().split(" ");
            int ver1 = Integer.parseInt(edge[0]);
            int ver2 = Integer.parseInt(edge[1]);
            cc.addEdge(ver1, ver2);
        }
        List<List<Integer>> components = cc.findConnectedComponents();
        writer.write(String.valueOf(components.size()) + "\n");
        for (List<Integer> component : components) {
            writer.write(component.size() + "\n");

            writer.write(String.join(" ", component.stream().map(String::valueOf).toArray(String[]::new)) + "\n");


        }
        writer.flush();
        reader.close();
        writer.close();
    }
}