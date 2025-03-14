package clothingstore.dao;

import clothingstore.model.UserDTO;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for UserDAO class.
 */
public class UserDAOTest {

    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAO();
    }

    @After
    public void tearDown() {
        userDAO = null;
    }

    /**
     * Test of getData method.
     */
    @Test
    public void testGetData() throws SQLException {
        System.out.println("getData");
        List<UserDTO> result = userDAO.getData();
        assertNotNull("List of users should not be null", result);
        assertTrue("List of users should not be empty", !result.isEmpty());
    }

    /**
     * Test of checkLogin method.
     */
    @Test
    public void testCheckLogin() throws SQLException {
        System.out.println("checkLogin");
        String userName = "admin";
        String password = "12345";

        // Assuming this user exists in the database
        UserDTO user = userDAO.checkLogin(userName, password);
        assertNotNull("User should not be null if credentials are correct", user);
        assertEquals("Username should match", userName, user.getUserName());
    }

    /**
     * Test of getTotalUsers method.
     */
    @Test
    public void testGetTotalUsers() throws SQLException {
        System.out.println("getTotalUsers");
        int result = userDAO.getTotalUsers();
        assertTrue("Total users count should be greater than 0", result > 0);
    }

    /**
     * Test of updatePasswordUser method.
     */
    @Test
    public void testUpdatePasswordUser() throws SQLException {
        System.out.println("updatePasswordUser");

        // Assuming "testuser" exists
        UserDTO user = userDAO.getUserByName("newuser");
        assertNotNull("User should exist before updating password", user);

        boolean result = userDAO.updatePasswordUser(user, "newpassword123");
        assertTrue("Password update should return true", result);
    }

    /**
     * Test of getUserByName method.
     */
    @Test
    public void testGetUserByName() throws SQLException {
        System.out.println("getUserByName");
        UserDTO user = userDAO.getUserByName("admin");
        assertNotNull("User should not be null", user);
        assertEquals("Username should match", "admin", user.getUserName());
    }

    /**
     * Test of getUserByEmail method.
     */
    @Test
    public void testGetUserByEmail() throws SQLException {
        System.out.println("getUserByEmail");
        UserDTO user = userDAO.getUserByEmail("admin@gmail.com");
        assertNotNull("User should not be null", user);
        assertEquals("Email should match", "admin@gmail.com", user.getEmail());
    }

    /**
     * Test of checkUserNameDuplicate method.
     */
    @Test
    public void testCheckUserNameDuplicate() throws SQLException {
        System.out.println("checkUserNameDuplicate");
        boolean result = userDAO.checkUserNameDuplicate("admin");
        assertTrue("Username should be found as duplicate", result);
    }

    /**
     * Test of registerUser method.
     */
    @Test
    public void testRegisterUser() throws SQLException {
        System.out.println("registerUser");

        UserDTO newUser = new UserDTO(0, "New", "User", "newuser123@example.com",
                "avatar.png", "newuser123", "password123", "Some address", "9876543210", 1, true);

        userDAO.registerUser(newUser);

        UserDTO registeredUser = userDAO.getUserByName("newuser");
        assertNotNull("User should be registered successfully", registeredUser);
        assertEquals("Username should match", "newuser", registeredUser.getUserName());
    }
}
