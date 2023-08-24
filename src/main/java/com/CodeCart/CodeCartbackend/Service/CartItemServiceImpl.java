package com.CodeCart.CodeCartbackend.Service;

import com.CodeCart.CodeCartbackend.Exceptions.CartItemException;
import com.CodeCart.CodeCartbackend.Exceptions.UserException;
import com.CodeCart.CodeCartbackend.Model.Cart;
import com.CodeCart.CodeCartbackend.Model.CartItem;
import com.CodeCart.CodeCartbackend.Model.Product;
import com.CodeCart.CodeCartbackend.Model.User;
import com.CodeCart.CodeCartbackend.Repository.CartItemRepository;
import com.CodeCart.CodeCartbackend.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());

        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {

        CartItem item = findCartItemById(id);
        User user=userService.findUserById(item.getUserId());

        if (user.getId().equals(userId)) {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*cartItem.getQuantity());
        }
        return cartItemRepository.save(item);
    }

    private CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

        if (opt.isPresent()){
            return opt.get();
        }
        throw new CartItemException("Item not found for "+cartItemId);
    }

    @Override
    public CartItem isCartItemPresent(Cart cart, Product product, String size, Long userId) {
        return cartItemRepository.isCartItemPresent(cart,product, size,userId);
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

        CartItem cartItem = findCartItemById(userId);

        User user = userService.findUserById(cartItem.getUserId());
        User reqUser = userService.findUserById(userId);

        if (user.getId().equals(reqUser.getId())){
            cartItemRepository.deleteById(cartItemId);
        }
        else {
            throw new UserException("can't remove other user's items");
        }

    }
}
