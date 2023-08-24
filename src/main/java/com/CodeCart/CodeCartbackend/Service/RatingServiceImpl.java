package com.CodeCart.CodeCartbackend.Service;

import com.CodeCart.CodeCartbackend.Exceptions.ProductException;
import com.CodeCart.CodeCartbackend.Model.Product;
import com.CodeCart.CodeCartbackend.Model.Rating;
import com.CodeCart.CodeCartbackend.Model.User;
import com.CodeCart.CodeCartbackend.Repository.RatingRepository;
import com.CodeCart.CodeCartbackend.Request.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Rating rating = new Rating();
        rating.setUser(user);
        rating.setProduct(product);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {

        return ratingRepository.getAllProductsRating(productId);
    }
}
