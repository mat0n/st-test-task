package com.st.urban.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    private static final String PHONE_XPATH = "/html/body/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[1]/span[1]";
    private static final String MAIL_XPATH = "/html/body/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[1]/span[2]/a";
    private static final String LOCATION_XPATH = "/html/body/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[2]/span";
    private static final String IMAGE_XPATH = "/html/body/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[3]/img";
    private static final String ADDRESS_XPATH = "//div[@class='contacts_row'][last()]";

    public SelenideElement getHeader() {
        return $(By.className("h1"));
    }

    public SelenideElement getPhone() {
       return $(By.xpath(PHONE_XPATH));
    }

    public SelenideElement getMail() {
        return $(By.xpath(MAIL_XPATH));
    }

    public SelenideElement getLocation() {
        return $(By.xpath(LOCATION_XPATH));
    }

    public SelenideElement getImage() {
        return $(By.xpath(IMAGE_XPATH));
    }

    public SelenideElement getAddress() {
        return $(By.xpath(ADDRESS_XPATH));
    }
}
