/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clothingstore.dao;

import clothingstore.model.CategoryDTO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class CategoryDAOTest {
    
    public CategoryDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getData method, of class CategoryDAO.
     */
    @Test
    public void testGetData() throws Exception {
        System.out.println("getData");
        CategoryDAO instance = new CategoryDAO();
        List<CategoryDTO> expResult = null;
        List<CategoryDTO> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoriesByTypeId method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoriesByTypeId() throws Exception {
        System.out.println("getCategoriesByTypeId");
        int typpid = 0;
        CategoryDAO instance = new CategoryDAO();
        List<CategoryDTO> expResult = null;
        List<CategoryDTO> result = instance.getCategoriesByTypeId(typpid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryById method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoryById() throws Exception {
        System.out.println("getCategoryById");
        int id = 0;
        CategoryDAO instance = new CategoryDAO();
        CategoryDTO expResult = null;
        CategoryDTO result = instance.getCategoryById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantityByName method, of class CategoryDAO.
     */
    @Test
    public void testGetQuantityByName() throws Exception {
        System.out.println("getQuantityByName");
        String name = "";
        CategoryDAO instance = new CategoryDAO();
        int expResult = 0;
        int result = instance.getQuantityByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCategory method, of class CategoryDAO.
     */
    @Test
    public void testInsertCategory() {
        System.out.println("insertCategory");
        String categoryName = "";
        String typeId = "";
        CategoryDAO instance = new CategoryDAO();
        boolean expResult = false;
        boolean result = instance.insertCategory(categoryName, typeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCategory method, of class CategoryDAO.
     */
    @Test
    public void testDeleteCategory() throws Exception {
        System.out.println("deleteCategory");
        String cid = "";
        CategoryDAO instance = new CategoryDAO();
        instance.deleteCategory(cid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCategory method, of class CategoryDAO.
     */
    @Test
    public void testEditCategory() throws Exception {
        System.out.println("editCategory");
        String name = "";
        String tId = "";
        String id = "";
        CategoryDAO instance = new CategoryDAO();
        instance.editCategory(name, tId, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CategoryDAO.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CategoryDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
