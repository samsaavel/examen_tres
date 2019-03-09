package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    LoginDAO loginDAO;

    @Autowired
    ModelMapper modelMapper;



    @Override
    public void createLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

    @Override
    public void deleteLogin(int id) {
        this.loginDAO.deleteById((long) id);
    }

    @Override
    public LoginDO readLogin(int id) {
        LoginDO loginDO = this.loginDAO.findById((long) id).get();
        return  loginDO;
    }

    @Override
    public void updateLogin(LoginDO loginDO) {
        this.loginDAO.findById((long) loginDO.getId());
        this.loginDAO.save(loginDO);
    }
}
