/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA;

/**
 *
 * @author ASUS
 */
import java.util.*;

public class HuffmanCoding {

    // Lớp nút cho cây Huffman
    static class Node implements Comparable<Node> {
        char ch;        // Ký tự (nếu là nút lá)
        int freq;       // Tần suất xuất hiện
        Node left;      // Nhánh trái
        Node right;     // Nhánh phải

        // Constructor cho nút lá
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }

        // Constructor cho nút cha
        Node(int freq, Node left, Node right) {
            this.ch = '\0'; // Không chứa ký tự (nút trung gian)
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        // So sánh tần suất để sử dụng trong PriorityQueue
        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    // Hàm xây dựng cây Huffman từ bảng tần suất
    public static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Tạo nút lá cho mỗi ký tự và thêm vào hàng đợi
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Xây dựng cây bằng cách kết hợp các nút
        while (pq.size() > 1) {
            Node left = pq.poll();      // Lấy nút có tần suất nhỏ nhất
            Node right = pq.poll();     // Lấy nút có tần suất nhỏ thứ hai
            Node parent = new Node(left.freq + right.freq, left, right);
            pq.add(parent);             // Thêm nút cha vào hàng đợi
        }

        return pq.poll(); // Trả về nút gốc của cây Huffman
    }

    // Hàm gán mã nhị phân cho các ký tự
    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) return;

        // Nếu là nút lá, gán mã cho ký tự
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.ch, code);
        }

        // Đệ quy gán mã: '0' cho nhánh trái, '1' cho nhánh phải
        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    // Hàm mã hóa chuỗi đầu vào
    public static String encode(String input, Map<Character, String> huffmanCodes) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : input.toCharArray()) {
            encoded.append(huffmanCodes.get(ch));
        }
        return encoded.toString();
    }

    // Hàm giải mã chuỗi nhị phân
    public static String decode(String encoded, Node root) {
        StringBuilder decoded = new StringBuilder();
        Node current = root;

        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                current = current.left;   // Di chuyển sang trái
            } else if (bit == '1') {
                current = current.right;  // Di chuyển sang phải
            }

            // Nếu đến nút lá, thêm ký tự và quay lại nút gốc
            if (current.left == null && current.right == null) {
                decoded.append(current.ch);
                current = root;
            }
        }
        return decoded.toString();
    }

    // Hàm main để chạy ví dụ
    public static void main(String[] args) {
        String input = "abracadabra";
        System.out.println("Chuỗi gốc: " + input);

        // Bước 1: Tính tần suất ký tự
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Tần suất ký tự: " + freqMap);

        // Bước 2 & 3: Xây dựng cây Huffman
        Node root = buildHuffmanTree(freqMap);

        // Bước 4: Gán mã Huffman
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        System.out.println("Mã Huffman: " + huffmanCodes);

        // Bước 5: Mã hóa chuỗi
        String encoded = encode(input, huffmanCodes);
        System.out.println("Chuỗi mã hóa: " + encoded);

        // Bước 6: Giải mã chuỗi
        String decoded = decode(encoded, root);
        System.out.println("Chuỗi giải mã: " + decoded);

        // Kiểm tra kết quả
        if (input.equals(decoded)) {
            System.out.println("Giải mã thành công!");
        } else {
            System.out.println("Giải mã thất bại!");
        }
    }
}
