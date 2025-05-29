import java.util.*;
class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if (source == destination) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    if (neighbor == destination) {
                        return true;
                    }
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество вершин: ");
        int n = scanner.nextInt();
        System.out.print("Количество рёбер: ");
        int edgesCount = scanner.nextInt();
        int[][] edges = new int[edgesCount][2];
        System.out.println("Введите рёбра: ");
        for (int i = 0; i < edgesCount; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.print("Источник: ");
        int source = scanner.nextInt();
        System.out.print("Пункт назначения: ");
        int destination = scanner.nextInt();
        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();
        boolean result = solution.validPath(n, edges, source, destination);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        scanner.close();
    }
}