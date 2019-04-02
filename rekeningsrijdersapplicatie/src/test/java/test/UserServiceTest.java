package test;

import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.services.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class UserServiceTest {

    private static UserService userService;

    private static RegistrationInfo registerInfo;

    private static LoginInfo loginInfo;

    @BeforeClass
    public static void setUp() {
        registerInfo = new RegistrationInfo();
        registerInfo.setEmail("user@test.com");
        registerInfo.setUsername("User_343");
        registerInfo.setPassword("Fsjksdi332");

        loginInfo = new LoginInfo();
        loginInfo.setUsername("User_343");
        loginInfo.setPassword("Fsjksdi332");
    }

    @Test
    public void register() {
        userService.register(registerInfo);

        assertNotNull(userService.login(loginInfo));
    }
}
