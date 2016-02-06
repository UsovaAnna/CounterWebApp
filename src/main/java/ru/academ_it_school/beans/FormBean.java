package ru.academ_it_school.beans;

/**
 * Created by ausova on 06.02.16.
 */
public class FormBean {
    private String address;
    private ClientBean clientBean;
    private String position;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientBean getClientBean() {
        return clientBean;
    }

    public void setClientBean(ClientBean clientBean) {
        this.clientBean = clientBean;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
