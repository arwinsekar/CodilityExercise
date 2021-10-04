package com.test.codility.test.steps;

import com.test.codility.test.pages.pages.WishListPage;
import io.cucumber.java.en.Given;

public class WishListPageSteps {

  private WishListPage page;
  String product;

  public WishListPageSteps(WishListPage page) {
    this.page = page;
  }

  @Given("I view my wishlist table and find total four selected items in my wishlist")
  public void iViewWishlist(){
    page.checkWishlist();
  }

}