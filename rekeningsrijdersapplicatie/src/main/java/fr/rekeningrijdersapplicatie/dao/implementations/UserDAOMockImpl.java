package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;
import fr.rekeningrijdersapplicatie.qualifiers.UserDAOMock;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@UserDAOMock
public class UserDAOMockImpl implements IUserDAO {

    private List<User> users = new ArrayList<User>();
    private int index = 0;

    @Override
    public User register(RegistrationInfo registrationInfo) {
        User user = new User();

        user.setId(index++);
        user.setUsername(registrationInfo.getUsername());
        user.setEmail(registrationInfo.getEmail());

        users.add(user);

        return user;
    }

    @Override
    public User login(LoginInfo loginInfo) {
        for (User user: users)
            if (user.getUsername().equals(loginInfo.getUsername()))
                return user;

        return null;
    }

    @Override
    public List<Vehicle> getVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo getUserInfo() {
        return null;
    }

    @Override
    public UserInfo editUserInfo() {
        return null;
    }
}
