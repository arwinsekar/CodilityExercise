package com.test.codility.test.pages.pages;

import com.test.codility.test.pages.base.PageObjectBase;
import com.test.codility.test.pages.common.Datatable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartListPage extends PageObjectBase {
  Datatable datatable = new Datatable();


  @FindBy(how = How.XPATH, using = "(//i[@class='la la-shopping-bag'])[1]")
  private WebElement cartBtn;

  @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Cart']")
  private WebElement cartPage;

  @Override
  public void trait() {
    assertDisplayed(cartPage, 5);
  }

  @Override
  public void navigateHere() {
    click(cartBtn);
    trait();
  }

  @FindBy(how = How.CSS, using = ".shop_table.shop_table_responsive.cart.woocommerce-cart-form__contents")
  private WebElement table;

  public boolean verifyItemInCart() {
    List<WebElement> tableTds = table.findElements(By.tagName("td"));
    String productName = tableTds.get(2).getText();
    return productName.equals(System.getProperty("productName"));
  }

}
