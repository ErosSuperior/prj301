package clothingstore.dao;

import clothingstore.model.CategoryDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class CategoryDAOTest {
    
    private CategoryDAO categoryDAO;
    
    @Before
    public void setUp() {
        categoryDAO = new CategoryDAO();
    }
    
    @After
    public void tearDown() {
        categoryDAO = null;
    }

    @Test
    public void testGetData() throws SQLException {
        System.out.println("getData");
        List<CategoryDTO> result = categoryDAO.getData();
        assertNotNull("List should not be null", result);
        assertTrue("List size should be non-negative", result.size() >= 0);
    }

    @Test
    public void testGetCategoriesByTypeId() throws SQLException {
        System.out.println("getCategoriesByTypeId");
        int typeId = 1; // Giả sử typeId 1 tồn tại trong database
        List<CategoryDTO> result = categoryDAO.getCategoriesByTypeId(typeId);
        assertNotNull("List should not be null", result);
        assertTrue("List size should be non-negative", result.size() >= 0);
        if (!result.isEmpty()) {
            assertEquals("Categories should match the requested type ID", 
                typeId, result.get(0).getType().getId());
        }
    }

    @Test
    public void testGetCategoryById() throws SQLException {
        System.out.println("getCategoryById");
        // Test với ID tồn tại (giả sử ID 1 tồn tại)
        CategoryDTO result = categoryDAO.getCategoryById(1);
        if (result != null) {
            assertEquals("Should return category with correct ID", 1, result.getId());
        }
        
        // Test với ID không tồn tại
        CategoryDTO resultNotExist = categoryDAO.getCategoryById(9999);
        assertNull("Should return null for non-existing ID", resultNotExist);
    }

    @Test
    public void testGetQuantityByName() throws SQLException {
        System.out.println("getQuantityByName");
        // Test với tên có thể tồn tại
        int result = categoryDAO.getQuantityByName("T-shirt");
        assertTrue("Quantity should be non-negative", result >= 0);
        
        // Test với tên không tồn tại
        int resultNotExist = categoryDAO.getQuantityByName("NonExistingCategory123");
        assertEquals("Should return 0 for non-existing category", 0, resultNotExist);
    }

    @Test
    public void testInsertCategory() {
        System.out.println("insertCategory");
        String categoryName = "TestCategory" + System.currentTimeMillis();
        String typeId = "1"; // Giả sử typeId 1 tồn tại
        
        boolean result = categoryDAO.insertCategory(categoryName, typeId);
        assertTrue("Insert should be successful", result);
        
        // Verify insertion
        try {
            int quantity = categoryDAO.getQuantityByName(categoryName);
            assertEquals("Category should exist after insertion", 1, quantity);
        } catch (SQLException e) {
            fail("Verification failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteCategory() throws SQLException {
        System.out.println("deleteCategory");
        // First insert a test category
        String categoryName = "DeleteTest" + System.currentTimeMillis();
        categoryDAO.insertCategory(categoryName, "1");
        
        // Get the inserted category's ID
        CategoryDTO inserted = categoryDAO.getData().stream()
            .filter(c -> c.getName().equals(categoryName))
            .findFirst()
            .orElse(null);
        
        assertNotNull("Inserted category should exist", inserted);
        
        // Delete it
        categoryDAO.deleteCategory(String.valueOf(inserted.getId()));
        
        // Verify deletion
        CategoryDTO deleted = categoryDAO.getCategoryById(inserted.getId());
        assertNull("Category should be null after deletion", deleted);
    }

    @Test
    public void testEditCategory() throws SQLException {
        System.out.println("editCategory");
        // First insert a test category
        String originalName = "EditTest" + System.currentTimeMillis();
        categoryDAO.insertCategory(originalName, "1");
        
        CategoryDTO inserted = categoryDAO.getData().stream()
            .filter(c -> c.getName().equals(originalName))
            .findFirst()
            .orElse(null);
        
        assertNotNull("Inserted category should exist", inserted);
        
        // Edit it
        String newName = "EditedCategory" + System.currentTimeMillis();
        categoryDAO.editCategory(newName, "1", String.valueOf(inserted.getId()));
        
        // Verify edit
        CategoryDTO edited = categoryDAO.getCategoryById(inserted.getId());
        assertEquals("Category name should be updated", newName, edited.getName());
    }
}