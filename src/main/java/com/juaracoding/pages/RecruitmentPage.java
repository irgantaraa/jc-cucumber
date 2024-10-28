package com.juaracoding.pages;

import com.juaracoding.utils.Utils;
import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
    private WebDriver driver;
    Utils utils  = new Utils();

    public RecruitmentPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement menuRecruitment;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']")
    private WebElement recruitmentMenu;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus'']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    @FindBy(xpath = "//button[normalize-space()='Add'")
    private WebElement btnAdd;

    public void setMenuRecruitment() {
        menuRecruitment.click();
    }

    public void addCandidate() {
        btnAdd.click();
        utils.delay(3);
        firstName.sendKeys("Juara");
        lastName.sendKeys("Coding");
        email.sendKeys("admin@juaracoding.co.id");
        resume.sendKeys("");
        btnSave.click();
    }



}
