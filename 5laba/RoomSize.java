import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class RoomSize {
    static char[][] maze;
    static boolean[][] visited;
    static int N;
    private static int calculateArea(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col] || maze[row][col] == '*') {
            return 0;
        }
        visited[row][col] = true;
        int area = 1;
        area += calculateArea(row - 1, col);
        area += calculateArea(row + 1, col);
        area += calculateArea(row, col - 1);
        area += calculateArea(row, col + 1);
        return area;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine().trim());
        maze = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            maze[i] = reader.readLine().trim().toCharArray();
        }
        String[] input = reader.readLine().trim().split(" ");
        int startRow = Integer.parseInt(input[0]) - 1;
        int startCol = Integer.parseInt(input[1]) - 1;
        int area = calculateArea(startRow, startCol);
        writer.write(String.valueOf(area) + "\n");
        writer.flush();
        reader.close();
        writer.close();
    }
}