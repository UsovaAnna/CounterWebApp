package ru.academ_it_school.factory.impl;


import org.springframework.stereotype.Component;
import ru.academ_it_school.beans.ClientBean;
import ru.academ_it_school.factory.ClientFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        Date date = convert("20.04.1991");
        clientBean.setDob(date);
        clientBean.setEmail("usova.anna.novosibirsk@gmail.com");
        clientBean.setPasswordHash("123456");
        return clientBean;
    }

    private Date convert(String dateString) {
        try {
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}
