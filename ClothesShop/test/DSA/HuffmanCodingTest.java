package DSA;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HuffmanCodingTest {
    
    @Before
    public void setUp() {
        // Khởi tạo trước mỗi test (nếu cần)
    }
    
    @After
    public void tearDown() {
        // Dọn dẹp sau mỗi test (nếu cần)
    }

    /**
     * Test phương thức buildHuffmanTree.
     */
    @Test
    public void testBuildHuffmanTree() {
        System.out.println("Testing buildHuffmanTree");
        // Tạo bản đồ tần suất
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);
        freqMap.put('b', 2);
        freqMap.put('c', 1);
        freqMap.put('d', 1);
        freqMap.put('r', 2);
        
        // Gọi phương thức xây dựng cây
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        
        // Kiểm tra kết quả
        assertNotNull("Cây Huffman không được null", root);
        assertEquals("Tần suất nút gốc phải bằng tổng tần suất", 11, root.freq);
        assertNotNull("Nút trái không được null", root.left);
        assertNotNull("Nút phải không được null", root.right);
    }

    /**
     * Test phương thức generateCodes.
     */
    @Test
    public void testGenerateCodes() {
        System.out.println("Testing generateCodes");
        // Tạo bản đồ tần suất
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);
        freqMap.put('b', 2);
        freqMap.put('c', 1);
        freqMap.put('d', 1);
        freqMap.put('r', 2);
        
        // Xây dựng cây và tạo mã
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> huffmanCodes = new HashMap<>();
        HuffmanCoding.generateCodes(root, "", huffmanCodes);
        
        // Kiểm tra kết quả
        assertEquals("Số lượng mã phải bằng số ký tự", 5, huffmanCodes.size());
        
        // Kiểm tra độ dài mã (ký tự tần suất cao có mã ngắn hơn)
        assertTrue("Mã của 'a' phải ngắn hơn hoặc bằng mã của 'c'", 
                   huffmanCodes.get('a').length() <= huffmanCodes.get('c').length());
        
        // Kiểm tra tính duy nhất của mã (không có mã nào là tiền tố của mã khác)
        for (char c1 : huffmanCodes.keySet()) {
            for (char c2 : huffmanCodes.keySet()) {
                if (c1 != c2) {
                    assertFalse("Mã của " + c1 + " không được là tiền tố của mã " + c2, 
                                huffmanCodes.get(c1).startsWith(huffmanCodes.get(c2)));
                }
            }
        }
    }

    /**
     * Test phương thức encode.
     */
    @Test
    public void testEncode() {
        System.out.println("Testing encode");
        String input = "abracadabra";
        
        // Tạo bản đồ tần suất từ chuỗi đầu vào
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Xây dựng cây và mã hóa
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> huffmanCodes = new HashMap<>();
        HuffmanCoding.generateCodes(root, "", huffmanCodes);
        String encoded = HuffmanCoding.encode(input, huffmanCodes);
        
        // Kiểm tra kết quả
        assertTrue("Chuỗi mã hóa không được rỗng", encoded.length() > 0);
        for (char bit : encoded.toCharArray()) {
            assertTrue("Chuỗi mã hóa chỉ chứa '0' hoặc '1'", bit == '0' || bit == '1');
        }
    }

    /**
     * Test phương thức decode.
     */
    @Test
    public void testDecode() {
        System.out.println("Testing decode");
        String input = "abracadabra";
        
        // Tạo bản đồ tần suất
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Xây dựng cây, mã hóa và giải mã
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> huffmanCodes = new HashMap<>();
        HuffmanCoding.generateCodes(root, "", huffmanCodes);
        String encoded = HuffmanCoding.encode(input, huffmanCodes);
        String decoded = HuffmanCoding.decode(encoded, root);
        
        // Kiểm tra kết quả
        assertEquals("Chuỗi giải mã phải khớp với chuỗi gốc", input, decoded);
    }

    /**
     * Test phương thức main.
     */
    @Test
    public void testMain() {
        System.out.println("Testing main");
        String[] args = null;
        HuffmanCoding.main(args);
        // Kiểm tra xem phương thức chạy mà không throw exception
        assertTrue("Phương thức main chạy thành công", true);
    }
}