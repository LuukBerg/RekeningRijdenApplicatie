package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;

public interface IUserDAO {
    User register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);

}
