package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.*;

import java.util.Set;

public interface  IUserDAO {
    User register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);

    Set<Vehicle> getVehicles();

    UserInfo getUserInfo();

    void updateUserInfo(UserInfo userInfo);
    
    User findByID(int id);
}
