package com.test.codility.test.steps;

import com.test.codility.setup.Hooks;
import com.test.codility.test.pages.pages.MainPage;
import io.cucumber.java.en.Given;

public class MainPageSteps {

  private final MainPage page;
  String product;

  public MainPageSteps(MainPage page) {

    this.page = page;
  }

  @Given("I add four {string} different products to my wishlist")
  public void iAddFourDiffProductsToMyWishlist(String SearchCategory){
    page.navigateHere();
    page.isPageReady();
    Hooks.takeScreenshot();
    page.selectProduct(SearchCategory);
  }

}