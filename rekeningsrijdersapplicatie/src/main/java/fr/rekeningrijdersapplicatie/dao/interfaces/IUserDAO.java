package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.pojos.Vehicle;

import java.util.List;

public interface IUserDAO {
    User register(RegistrationInfo registrationInfo);

    User login(LoginInfo loginInfo);

    List<Vehicle> getVehicles();
}
