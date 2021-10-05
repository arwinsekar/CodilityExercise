package com.test.codility.test.pages.pages;

import com.test.codility.setup.Hooks;
import com.test.codility.test.pages.base.PageObjectBase;
import com.test.codility.test.pages.common.Datatable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class WishListPage extends PageObjectBase {
  Map<Integer, String> unsortMap = new HashMap<>();
  LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
  Datatable datatable = new Datatable();

  @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Wishlist']")
  private WebElement wishlistBanner;

  @FindBy(how = How.CSS, using = "div[class='header-right col-md-3 hidden-xs'] i[class='lar la-heart']")
  public WebElement wishList;

  @FindBy(how = How.CLASS_NAME, using = "product-price")
  public List<WebElement> productPriceList;

  @FindBy(how = How.CLASS_NAME, using = "woocommerce-message")
  public WebElement productAddedToCart;

  @Override
  public void trait() {
    assertDisplayed(wishlistBanner, 10);
  }

  @Override
  public void navigateHere() {
    click(wishList);
    trait();
  }

  public int checkWishlist() {
    final String[] price = {null};
    IntStream.range(1, productPriceList.size()).forEach(index -> {
      if (productPriceList.get(index).getText().contains(" – ")) {
        price[0] = productPriceList.get(index).getText().split(" – ")[0];
      } else if (productPriceList.get(index).getText().contains(" ")) {
        price[0] = productPriceList.get(index).getText().split(" ")[1];
      } else {
        price[0] = productPriceList.get(index).getText();
      }
      unsortMap.put(index, price[0].replace("£", ""));
    });
    return productPriceList.size() - 1;
  }

   public void fetchLowestPrice() {
     unsortMap.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue())
             .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
     Object itemKey = sortedMap.keySet().toArray()[0];
     String productName = driver.findElement(By.xpath("(//td[@class='product-name'])[" + itemKey + "]")).getText();
     System.setProperty("productName", productName);
     driver.findElement(By.xpath("(//td[@class='product-add-to-cart'])[" + itemKey + "]")).click();
    }

    public void checkItemAddedToCart() {
      Hooks.takeScreenshot();
      assertDisplayed(productAddedToCart, 5);
    }

}
