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

    private final List<User> users = new ArrayList<User>();

    private static long index = 0;

    @Override
    public User register(RegistrationInfo registrationInfo) {
//        user.setId(index++);
//
//        users.add(user);
        return null;
    }

    @Override
    public User login(LoginInfo loginInfo) {
        for (User user : users) {
            if (user.getUsername().equals(loginInfo.getUsername())) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User findByID(long id) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            long userId = user.getId();
            if (userId == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void updateUser(User arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
