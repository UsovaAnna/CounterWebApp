package factory.impl;


import beans.ClientBean;
import factory.ClientFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ausova on 06.02.16.
 */

@Component("clientFactory")
public class ClientFactoryImpl implements ClientFactory {
    public ClientBean createClientBean() {
        ClientBean clientBean = new ClientBean();
        clientBean.setFirstName("Anna");
        clientBean.setLastName("Usova");
        clientBean.setDob(new Date("20.04.1991"));
        clientBean.setEmail("usova.anna.novosibirsk@gmail.com");
        clientBean.setPasswordHash("123456");
        return clientBean;
    }
}
