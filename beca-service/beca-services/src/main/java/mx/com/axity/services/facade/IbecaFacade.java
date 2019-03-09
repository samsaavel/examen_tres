package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;

import java.util.List;

public interface IbecaFacade {

    void saveLogin(LoginTO loginTO);
    void deleteLogin (int id);
    LoginTO readLogin (int id);
    void updateLogin(LoginTO loginTO);
}
