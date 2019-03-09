package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveLogin(LoginTO loginTO) {
        LoginDO loginDO = modelMapper.map(loginTO, LoginDO.class);
        this.becaService.createLogin(loginDO);
    }

    @Override
    public void deleteLogin(int id) {
        this.becaService.deleteLogin(id);
        return;
    }

    @Override
    public LoginTO readLogin(int id) {
        LoginDO loginDO = this.becaService.readLogin(id);
        LoginTO loginTO = modelMapper.map(loginDO, LoginTO.class);
        return loginTO;
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        this.becaService.readLogin(loginTO.getId());
        LoginDO loginDO = modelMapper.map(loginTO, LoginDO.class);
        this.becaService.updateLogin(loginDO);
    }
}
