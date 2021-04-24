package Medtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {
    User user = new User("Steve", "JAvatures", "SteveJ", "password");
    @Test
    public void checkUserCreated(){
        assertNotNull(user);;
    }

    @Test
    public void checkGetFName(){
        String firstName = user.getFname();
        assertEquals(firstName, "Steve");
    }

    @Test
    public void checksetFName(){
        user.setFname("Steven");;
        assertEquals(user.getFname(), "Steven");
    }

    @Test
    public void checkGetLName(){
        String lastName = user.getLname();
        assertEquals(lastName, "JAvatures");
    }

    @Test
    public void checkSetLName(){
        user.setLname("Java-ture");
        assertEquals(user.getLname(), "Java-ture");
    }

    @Test
    public void checkGetUserName(){
        String userName = user.getUserName();
        assertEquals(userName, "SteveJ");
    }

    @Test
    public void checkSetUserName(){
        user.setUserName("SteveJava");
        assertEquals(user.getUserName(), "SteveJava");
    }

    @Test
    public void checkGetPassword(){
        String password = user.getPassword();
        assertEquals(password, "password");
    }

    @Test
    public void checkSetPassword(){
        user.setPassword("p4ssw0rd");;
        assertEquals(user.getPassword(), "p4ssw0rd");
    }
}
