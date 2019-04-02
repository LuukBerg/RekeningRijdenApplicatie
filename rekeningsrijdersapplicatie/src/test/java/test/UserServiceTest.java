package test;

import fr.rekeningrijdersapplicatie.apis.RekeningAdministratieAPIMock;
import fr.rekeningrijdersapplicatie.dao.implementations.UserDAOMockImpl;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.services.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    private static UserService userService;
    private static RegistrationInfo registerInfo;
    private static LoginInfo loginInfo;

    @BeforeClass
    public static void setUp() {
        userService = new UserService(new UserDAOMockImpl(), new RekeningAdministratieAPIMock());
        
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
