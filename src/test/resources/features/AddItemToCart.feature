@AddToCart
Feature: As a user, I would like to Add lowest priced item from wishlist to cart
  #*
#* @author Arwin
#**/

  Scenario Outline: As a user, I would like to Add lowest priced item from wishlist to cart
    Given I add four "<itemCount>" different products to my wishlist
    When I view my wishlist table and find total four selected items in my wishlist
#    When I search for lowest price product
#    And I am able to add the lowest price item to my cart
#    Then I am able to verify the item in cart
    Examples:
      | itemCount                |
      |4|