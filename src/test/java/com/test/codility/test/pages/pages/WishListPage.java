package com.test.codility.test.pages.pages;

import com.test.codility.test.pages.base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class WishListPage extends PageObjectBase {

  @FindBy(xpath = "//h1[normalize-space()='Wishlist']")
  private WebElement wishlistBanner;

  @FindBy(css = "div[class='header-right col-md-3 hidden-xs'] i[class='lar la-heart']")
  public WebElement wishList;


  @Override
  public void trait() {
    assertDisplayed(wishlistBanner, 10);
  }

  @Override
  public void navigateHere() {
    click(wishList);
    trait();
  }

  public void checkWishlist(){
    Map<String, Integer> unsortMap = new HashMap<>();
    click(wishList);
    assertDisplayed(wishlistBanner, 10);
    List <WebElement> itemList = driver.findElements(By.className("product-price"));
    IntStream.range(1,4).forEach(index -> {
      //String price = itemList.get(index).getText().contains("-") ? (itemList.get(index).getText().split("-")(0)) : itemList.get(1).getText();
      //unsortMap.put(index, Integer.valueOf(price.replace("£", "")));
    });
   /*
    priceList.add(Integer.valueOf(price.replace("£", "")));
    Collections.sort(priceList);
    priceList.get(1);
    trait();*/
  }

}
