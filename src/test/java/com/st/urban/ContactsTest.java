package com.st.urban;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.CssValue;
import com.st.urban.entity.ContactsEntity;
import com.st.urban.entity.NavigationEntity;
import com.st.urban.helpers.TestJsonReader;
import com.st.urban.page.ContactsPage;
import com.st.urban.page.NavigationPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ContactsTest {

    private static final String ST_BY_URI = "https://www.st.by/%s";
    private static final String ST_BY_CONTACTS_URI = ST_BY_URI + "contacts/";

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }

    @Step("Check contacts page with locale {locale}, browser {browser}")
    @Test(dataProvider = "contactsPageTestDp")
    public void contactsPageTest(String locale, String expectedDataPath, String expectedCssAttributesPath, String browser) {
        Configuration.browser = browser;

        ContactsEntity contactsEntity = TestJsonReader.readJson(getClass(), expectedDataPath, ContactsEntity.class);
        Map<String, CssValue[]> expectedCssAttributes = TestJsonReader.readCssAttributeJson(getClass(), expectedCssAttributesPath);
        ContactsPage contactsPage = open(String.format(ST_BY_CONTACTS_URI, locale), ContactsPage.class);

        SelenideElement headerElement = contactsPage.getHeader();
        SelenideElement phoneElement = contactsPage.getPhone();
        SelenideElement mailElement = contactsPage.getMail();
        SelenideElement locationElement = contactsPage.getLocation();
        SelenideElement imageElement = contactsPage.getImage();
        SelenideElement addressElement = contactsPage.getAddress();

        headerElement
                .shouldBe(Condition.visible)
                .shouldHave(expectedCssAttributes.get("header"));
        phoneElement
                .shouldBe(Condition.visible)
                .shouldBe(expectedCssAttributes.get("phone"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(headerElement.getText())
                .as("Header text value")
                .isEqualTo(contactsEntity.getHeader());
        softly.assertThat(phoneElement.getText())
                .as("Phone text value")
                .contains(contactsEntity.getPhone());
        softly.assertThat(mailElement.getText())
                .as("Email text value")
                .isEqualTo(contactsEntity.getMail());
        softly.assertThat(mailElement.getAttribute("href"))
                .as("Email href")
                .isEqualTo(contactsEntity.getMailHref());
        softly.assertThat(locationElement.getText())
                .as("Location text value")
                .contains(contactsEntity.getLocation());
        softly.assertThat(imageElement.getAttribute("src"))
                .as("Image href")
                .contains(contactsEntity.getImageHref());
        softly.assertThat(addressElement.getText())
                .as("Address text value")
                .contains(contactsEntity.getAddress());
        softly.assertAll();
    }

    @DataProvider
    public Object[][] contactsPageTestDp() {
        return new Object[][]{
                {"", "/contacts/contacts_ru.json", "/cssAttributes.json", "edge"},
                {"en/", "/contacts/contacts_en.json", "/cssAttributes.json", "edge"},
                {"by/", "/contacts/contacts_by.json", "/cssAttributes.json", "edge"},
                {"", "/contacts/contacts_ru.json", "/cssAttributes.json", "chrome"},
                {"en/", "/contacts/contacts_en.json", "/cssAttributes.json", "chrome"},
                {"by/", "/contacts/contacts_by.json", "/cssAttributes.json", "chrome"}
        };
    }

    @Step("Check navigation page contacts with locale {locale}, browser {browser}")
    @Test(dataProvider = "navigationPageTestDp")
    public void navigationPageTest(String locale, String expectedDataPath, String browser) {
        Configuration.browser = browser;

        NavigationEntity navigationEntity = TestJsonReader.readJson(getClass(), expectedDataPath, NavigationEntity.class);
        NavigationPage navigationPage = open(String.format(ST_BY_URI, locale), NavigationPage.class);

        SelenideElement phoneElement = navigationPage.getPhone();
        SelenideElement allContactsElement = navigationPage.getAllContacts();
        SelenideElement addressElement = navigationPage.getAddress();
        SelenideElement indexElement = navigationPage.getIndex();
        SelenideElement mailElement = navigationPage.getMail();
        SelenideElement fbElement = navigationPage.getFb();
        SelenideElement inElement = navigationPage.getIn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(phoneElement.getText())
                .as("Phone text value")
                .isEqualTo(navigationEntity.getPhone());
        softly.assertThat(allContactsElement.getText())
                .as("All contacts text value")
                .isEqualTo(navigationEntity.getAllContacts());
        softly.assertThat(addressElement.getText())
                .as("Address text value")
                .isEqualTo(navigationEntity.getAddress());
        softly.assertThat(indexElement.getText())
                .as("Index text value")
                .contains(navigationEntity.getIndex());
        softly.assertThat(mailElement.getText())
                .as("Email text value")
                .isEqualTo(navigationEntity.getMail());
        softly.assertThat(mailElement.getAttribute("href"))
                .as("Email href")
                .isEqualTo(navigationEntity.getMailHref());
        softly.assertThat(fbElement.getAttribute("href"))
                .as("Facebook href")
                .isEqualTo(navigationEntity.getFbHref());
        softly.assertThat(inElement.getAttribute("href"))
                .as("Linkedin href")
                .isEqualTo(navigationEntity.getInHref());
        softly.assertAll();
    }

    @DataProvider
    public Object[][] navigationPageTestDp() {
        return new Object[][]{
                {"", "/navigation/navigation_ru.json", "edge"},
                {"en/", "/navigation/navigation_en.json", "edge"},
                {"by/", "/navigation/navigation_by.json", "edge"},
                {"", "/navigation/navigation_ru.json", "chrome"},
                {"en/", "/navigation/navigation_en.json", "chrome"},
                {"by/", "/navigation/navigation_by.json", "chrome"}
        };
    }
}
