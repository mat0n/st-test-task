package com.st.urban.entity;

import com.codeborne.selenide.conditions.CssValue;

import java.util.List;

public class ContactsEntity {

    private String header;
    private List<String> phone;
    private String mail;
    private String mailHref;
    private List<String> location;
    private String imageHref;
    private String companyName;
    private List<String> address;

    private CssValue cssData;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public String getMailHref() {
        return mailHref;
    }

    public void setMailHref(String mailHref) {
        this.mailHref = mailHref;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CssValue getCssData() {
        return cssData;
    }

    public void setCssData(CssValue cssData) {
        this.cssData = cssData;
    }

    @Override
    public String toString() {
        return "ContactsEntity{" +
                "header='" + header + '\'' +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                ", mailHref='" + mailHref + '\'' +
                ", location=" + location +
                ", imageHref='" + imageHref + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", cssData=" + cssData +
                '}';
    }
}
