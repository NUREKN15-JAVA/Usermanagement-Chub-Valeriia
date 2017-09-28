package test.java;

import main.java.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * Author Lera
 * created 25.09.2017.
 */

public class UserTest {
    private User user;
    private Date dateOfBirth;

    @Before
    public void setUp() throws Exception {
        user = new User();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1994, Calendar.OCTOBER, 27);
        dateOfBirth = calendar.getTime();
    }

    @Test
    public void getFullName() {
        user.setFirstName("Valeriia");
        user.setLastName("Chub");
        Assert.assertEquals("Chub, Valeriia", user.getFullName());

    }

    @Test
    public void getFullNameWithoutFirstName() {
        user.setLastName("Chub");
        try {
            user.getFullName();
            fail("IllegalStateException expecting");
        } catch (IllegalStateException e) {

        }
    }

    @Test
    public void getAge() {
        user.setDateOfBirth(dateOfBirth);
        Assert.assertEquals(2017 - 1994, user.getAge());
    }
}
