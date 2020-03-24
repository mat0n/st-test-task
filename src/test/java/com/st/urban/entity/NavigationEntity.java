package com.st.urban.entity;

import java.util.List;

public class NavigationEntity {

    private String phone;
    private String allContacts;
    private String address;
    private List<String> index;
    private String mail;
    private String mailHref;
    private String fbHref;
    private String inHref;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(String allContacts) {
        this.allContacts = allContacts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getIndex() {
        return index;
    }

    public void setIndex(List<String> index) {
        this.index = index;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailHref() {
        return mailHref;
    }

    public void setMailHref(String mailHref) {
        this.mailHref = mailHref;
    }

    public String getFbHref() {
        return fbHref;
    }

    public void setFbHref(String fbHref) {
        this.fbHref = fbHref;
    }

    public String getInHref() {
        return inHref;
    }

    public void setInHref(String inHref) {
        this.inHref = inHref;
    }

    @Override
    public String toString() {
        return "NavigationEntity{" +
                "address='" + address + '\'' +
                ", index='" + index + '\'' +
                ", mail='" + mail + '\'' +
                ", mailHref='" + mailHref + '\'' +
                '}';
    }
}
