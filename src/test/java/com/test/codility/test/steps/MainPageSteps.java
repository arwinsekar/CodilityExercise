package com.test.codility.test.steps;

import com.test.codility.test.pages.pages.MainPage;
import io.cucumber.java.en.Given;

public class MainPageSteps {

  private MainPage page;
  String product;

  public MainPageSteps(MainPage page) {

    this.page = page;
  }

  @Given("I add four {string} different products to my wishlist")
  public void iAddFourDiffProductsToMyWishlist(String itemcount){
    page.navigateHere();
    page.isPageReady();
    page.selectProduct("All Categories");
  }

}