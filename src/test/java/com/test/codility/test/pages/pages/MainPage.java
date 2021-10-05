package com.test.codility.test.pages.pages;

import com.test.codility.setup.Config;
import com.test.codility.test.pages.base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.IntStream;

public class MainPage extends PageObjectBase {

  @FindBy(how = How.CSS, using = "div[class='site-heading col-md-3 hidden-xs'] img[alt='TESTSCRIPTDEMO']")
  private WebElement logo;

  @FindBy(how = How.CLASS_NAME, using = "header-search-button")
  public WebElement searchButton;

  @FindBy(how = How.CSS, using = "#cc-window > div.cc-compliance.cc-highlight > a.cc-btn.cc-accept-all.cc-btn-no-href")
  public WebElement acceptCookies;

  @FindBy(how = How.NAME, using = "product_cat")
  public WebElement productSelection;

  @FindBy(how = How.CSS, using = "#yith-wcwl-popup-message")
  public WebElement productAddedPopup;

  @FindBy(how = How.XPATH, using = "(//span[contains(text(),'Add to wishlist')])[1]")
  public WebElement wishlistBtn;

  @Override
  public void trait() {
    assertDisplayed(logo, 10);
  }

  @Override
  public void navigateHere() {
    loadEnv(Config.getEnv());
    trait();
  }

  public void selectProduct(String productName){
    acceptCookies.click();
    Select productList = new Select(productSelection);
    productList.selectByVisibleText(productName);
    searchButton.click();
    List <WebElement> products = productList.getOptions();
    /*IntStream.range(1,products.size()).forEach(index -> {
      waitForNotStale(productSelection,10);
      productList.selectByVisibleText(products.get(index).getText());
      searchButton.click();
      driver.findElement(By.xpath("(//span[contains(text(),'Add to wishlist')])[1]")).click();
    });*/

      IntStream.range(1,5).forEach(index -> {
        waitForNotStale(wishlistBtn, 10);
        driver.findElement(By.xpath("(//span[contains(text(),'Add to wishlist')])["+ (index + 1) +"]")).click();
        waitForInvisibility(productAddedPopup,10);


      });


  }



  public void isPageReady() {
    trait();
  }
}
