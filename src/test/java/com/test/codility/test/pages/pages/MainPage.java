package com.test.codility.test.pages.pages;

import com.test.codility.setup.Config;
import com.test.codility.test.pages.base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.stream.IntStream;

public class MainPage extends PageObjectBase {

  @FindBy(css = "div[class='site-heading col-md-3 hidden-xs'] img[alt='TESTSCRIPTDEMO']")
  private WebElement logo;

  @FindBy(xpath = "//a[@title='Manage my personal information']")
  public WebElement personalInformation;

  @FindBy(css = "button[type='submit']")
  public WebElement searchButton;

  @FindBy(css = "#cc-window > div.cc-compliance.cc-highlight > a.cc-btn.cc-accept-all.cc-btn-no-href")
  public WebElement acceptCookies;

  @FindBy(name = "product_cat")
  public WebElement productSelection;

  @Override
  public void trait() {
    assertDisplayed(logo, 10);
  }

  public void selectProduct(String productName){
    acceptCookies.click();
    Select productList = new Select(productSelection);
    productList.selectByVisibleText(productName);
    searchButton.click();
      IntStream.range(1,5).forEach(index -> {
            driver.findElement(By.xpath("(//span[contains(text(),'Add to wishlist')])["+ (index) + "]")).click();
      });

  }

  @Override
  public void navigateHere() {
    loadEnv(Config.getEnv());
  }

  public void isPageReady() {
    trait();
  }
}
