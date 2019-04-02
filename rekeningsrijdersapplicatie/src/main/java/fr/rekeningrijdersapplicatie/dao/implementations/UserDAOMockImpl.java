package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.pojos.Vehicle;
import fr.rekeningrijdersapplicatie.qualifiers.UserDAOMock;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
@UserDAOMock
public class UserDAOMockImpl implements IUserDAO {
    @Override
    public User register(RegistrationInfo registrationInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(LoginInfo loginInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
