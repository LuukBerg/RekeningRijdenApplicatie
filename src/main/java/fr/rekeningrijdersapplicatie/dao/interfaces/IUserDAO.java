package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.*;

public interface IUserDAO {

    User register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);
    
    void updateUser(User user);

    User findByID(long id);
}
