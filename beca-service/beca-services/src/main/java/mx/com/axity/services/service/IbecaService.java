package mx.com.axity.services.service;



import mx.com.axity.model.LoginDO;

public interface IbecaService {

    void createLogin(LoginDO loginDO);
    void deleteLogin(int id);
    LoginDO readLogin(int id);
    void updateLogin(LoginDO loginDO);
}
