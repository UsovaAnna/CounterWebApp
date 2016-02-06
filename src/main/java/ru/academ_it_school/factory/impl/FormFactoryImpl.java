package ru.academ_it_school.factory.impl;



import org.springframework.stereotype.Component;
import ru.academ_it_school.beans.FormBean;
import ru.academ_it_school.factory.ClientFactory;
import ru.academ_it_school.factory.FormFactory;

/**
 * Created by ausova on 06.02.16.
 */

@Component("formFactory")
public class FormFactoryImpl implements FormFactory {
    private ClientFactory clientFactory = new ClientFactoryImpl();

    public FormBean createFormBean() {
        FormBean formBean = new FormBean();
        formBean.setAddress("Moskva, Pushkina 3");
        formBean.setClientBean(clientFactory.createClientBean());
        formBean.setPosition("manager");
        return formBean;
    }
}
