package DSA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
import java.util.*;

public class ChanTrau {

    private static int MAX = 100; // Giới hạn kích thước ma trận
    static int[][] graph = new int[MAX][MAX]; // Ma trận đồ thị
    private static int[] matchL = new int[MAX]; // Ghép cặp từ trâu sang cánh đồng
    private static int[] matchR = new int[MAX]; // Ghép cặp từ cánh đồng sang trâu
    private static boolean[] seen = new boolean[MAX]; // Đánh dấu các cánh đồng đã duyệt
    static int n; // Số trâu 👎 và số cánh đồng (m)
    static int m; // Số trâu 👎 và số cánh đồng (m)

    // Tìm ghép cặp cho con trâu u bằng DFS
    private static boolean dfs(int u) {
        for (int v = 0; v < m; v++) {
            if (graph[u][v] == 1 && !seen[v]) {
                seen[v] = true;
                if (matchR[v] == -1 || dfs(matchR[v])) {
                    matchL[u] = v;
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Tính số ghép cặp cực đại
    public static int maxMatching() {
        Arrays.fill(matchL, -1); // Khởi tạo ghép cặp cho trâu
        Arrays.fill(matchR, -1); // Khởi tạo ghép cặp cho cánh đồng
        int matching = 0;
        for (int u = 0; u < n; u++) {
            Arrays.fill(seen, false); // Reset mảng seen cho mỗi lần duyệt
            if (dfs(u)) {
                matching++;
            }
        }
        return matching;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng trâu và cánh đồng
        System.out.print("Nhập số con trâu (n): ");
        n = scanner.nextInt();
        System.out.print("Nhập số cánh đồng (m): ");
        m = scanner.nextInt();

        // Nhập ma trận nhị phân
        System.out.println("Nhập ma trận nhị phân (n x m):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Tính và in kết quả
        int matching = maxMatching();
        System.out.println("Số con trâu cần thiết: " + matching);
        System.out.print("Các con trâu được chọn (index từ 0): ");
        for (int u = 0; u < n; u++) {
            if (matchL[u] != -1) {
                System.out.print(u + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
