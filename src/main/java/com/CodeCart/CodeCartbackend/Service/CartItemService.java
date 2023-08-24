package com.CodeCart.CodeCartbackend.Service;

import com.CodeCart.CodeCartbackend.Exceptions.CartItemException;
import com.CodeCart.CodeCartbackend.Exceptions.ProductException;
import com.CodeCart.CodeCartbackend.Exceptions.UserException;
import com.CodeCart.CodeCartbackend.Model.Cart;
import com.CodeCart.CodeCartbackend.Model.CartItem;
import com.CodeCart.CodeCartbackend.Model.Product;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem)throws CartItemException, UserException;

    public CartItem isCartItemPresent(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId, Long cartItemId)throws CartItemException, UserException;
}
