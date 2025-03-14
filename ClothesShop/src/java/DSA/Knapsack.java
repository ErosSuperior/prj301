/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA;

/**
 *
 * @author Admin
 */
public class Knapsack {

    /**
     * Giải bài toán cái túi 0/1 bằng quy hoạch động.
     *
     * @param W     Sức chứa tối đa của túi
     * @param wt    Mảng trọng lượng của các vật phẩm
     * @param val   Mảng giá trị của các vật phẩm
     * @param n     Số lượng vật phẩm
     * @return      Giá trị lớn nhất có thể đạt được
     */
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        // Tạo bảng dp với kích thước (n+1) x (W+1)
        int[][] dp = new int[n + 1][W + 1];

        // Xây dựng bảng dp
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] > w) {
                    // Nếu trọng lượng vật phẩm lớn hơn sức chứa hiện tại
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // So sánh giữa việc chọn và không chọn vật phẩm
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        // Giá trị lớn nhất nằm ở dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {
        // Ví dụ
        int[] val = {100}; // Giá trị của các vật phẩm
        int[] wt = {10};    // Trọng lượng của các vật phẩm
        int W = 10;                 // Sức chứa tối đa của túi
        int n = 1;         // Số lượng vật phẩm

        // Gọi hàm knapsack và in kết quả
        int maxValue = knapsack(W, wt, val, n);
        System.out.println("Giá trị lớn nhất có thể đạt được: " + maxValue);
    }
}