package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless
@Default
public class UserDAOJPAImpl implements IUserDAO {

    public User register(RegistrationInfo registrationInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User login(LoginInfo loginInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
