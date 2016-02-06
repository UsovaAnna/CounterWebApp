package factory.impl;


import beans.FormBean;
import factory.ClientFactory;
import factory.FormFactory;
import org.springframework.stereotype.Component;

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
