package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.*;

import java.util.List;

public interface  IUserDAO {
    User register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);

    List<Vehicle> getVehicles();

    UserInfo getUserInfo();

    UserInfo editUserInfo();
}
