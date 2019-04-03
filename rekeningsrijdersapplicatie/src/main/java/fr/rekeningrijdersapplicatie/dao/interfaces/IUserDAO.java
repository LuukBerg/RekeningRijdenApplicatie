package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.*;

import java.util.Set;

public interface  IUserDAO {
    void register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);

    Set<Vehicle> getVehicles();
    
    User findByID(long id);
}
