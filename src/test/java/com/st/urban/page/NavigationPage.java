package com.st.urban.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {

    private static final String ADDRESS_XPATH = "//span[@class='h4']";
    private static final String INDEX_XPATH = "/html/body/footer/div[2]/span/span/span[2]";
    private static final String MAIL_XPATH = "/html/body/footer/div[2]/span/span/span[2]/a";
    private static final String FB_XPATH = "//a[@class='foo_btn']";
    private static final String IN_XPATH = "//a[@class='foo_btn'][last()]";

    public SelenideElement getPhone() {
        return $(By.className("tel"));
    }

    public SelenideElement getAllContacts() {
        return $(By.className("txt_smlst"));
    }

    public SelenideElement getAddress() {
        return $(By.xpath(ADDRESS_XPATH));
    }

    public SelenideElement getIndex() {
        return $(By.xpath(INDEX_XPATH));
    }

    public SelenideElement getMail() {
        return $(By.xpath(MAIL_XPATH));
    }

    public SelenideElement getFb() {
        return $(By.xpath(FB_XPATH));
    }

    public SelenideElement getIn() {
        return $(By.xpath(IN_XPATH));
    }


}
