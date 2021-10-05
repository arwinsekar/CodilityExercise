package com.test.codility.test.steps;

import com.test.codility.setup.Hooks;
import com.test.codility.test.pages.pages.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;

public class WishListPageSteps {

  @Getter
  @Setter
  private final WishListPage page;
  String productName;

  public WishListPageSteps(WishListPage page) {
    this.page = page;
  }

  @When("I view my wishlist table and find total four {string} selected items in my wishlist")
  public void iViewWishlist(String itemCountExp){
    page.navigateHere();
    Hooks.takeScreenshot();
    page.assertEquals(page.checkWishlist() == Integer.parseInt(itemCountExp), true);
  }

  @And("I search for lowest price product")
  public void searchLowestPrice() {
    page.fetchLowestPrice();
  }

  @Given("I am able to add the lowest price item to my cart")
  public void lowestPricedItemAddedToCart(){
    page.checkItemAddedToCart();
    Hooks.takeScreenshot();
  }

}