package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;



    @RequestMapping(value = "/logins", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveLogin(@RequestBody LoginTO loginTO) {

        this.IbecaFacade.saveLogin(loginTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/loginu", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateLogin(@RequestBody LoginTO loginTO) {
        this.IbecaFacade.updateLogin(loginTO);
        return new ResponseEntity<> (HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity findLogin(@RequestParam(value = "id") int id) {
        LOG.info("Login id");
        LOG.info(id);
        LoginTO loginTO = this.IbecaFacade.readLogin(id);
        LOG.info("Login");
        LOG.info(loginTO.getId());
        LOG.info(loginTO.getUsuario());
        LOG.info(loginTO.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/logind", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteLogin(@RequestParam(value = "id") int id) {
        LOG.info("Login id");
        LOG.info(id);
        this.IbecaFacade.deleteLogin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
}
