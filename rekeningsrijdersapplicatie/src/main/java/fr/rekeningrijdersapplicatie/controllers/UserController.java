package fr.rekeningrijdersapplicatie.controllers;

import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @POST
    @Path("/register")
    public void register(RegistrationInfo registrationInfo) {
        userService.register(registrationInfo);
    }

    @POST
    @Path("/login")
    public void login(LoginInfo loginInfo) {
        userService.login(loginInfo);
    }

}
