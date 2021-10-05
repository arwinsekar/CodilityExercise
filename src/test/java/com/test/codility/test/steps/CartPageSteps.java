package com.test.codility.test.steps;

import com.test.codility.setup.Hooks;
import com.test.codility.test.pages.pages.CartListPage;
import io.cucumber.java.en.Then;

public class CartPageSteps {

  private final CartListPage page;
  String product;

  public CartPageSteps(CartListPage page) {
    this.page = page;
  }

  @Then("I am able to verify the item in cart")
  public void searchLowestPrice() {
    page.navigateHere();
    page.assertEquals(page.verifyItemInCart(), true);
    Hooks.takeScreenshot();
  }

}