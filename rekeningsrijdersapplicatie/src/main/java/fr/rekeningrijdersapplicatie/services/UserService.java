package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.qualifiers.UserDAOMock;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

    @Inject
    @UserDAOMock
    private IUserDAO userDao;

    public User register(RegistrationInfo registrationInfo){
        return userDao.register(registrationInfo);
    }

    public User login(LoginInfo loginInfo){
        return userDao.login(loginInfo);
    }
}
