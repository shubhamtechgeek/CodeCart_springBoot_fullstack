package com.CodeCart.CodeCartbackend.Controller;

import com.CodeCart.CodeCartbackend.Exceptions.ProductException;
import com.CodeCart.CodeCartbackend.Exceptions.UserException;
import com.CodeCart.CodeCartbackend.Model.Rating;
import com.CodeCart.CodeCartbackend.Model.User;
import com.CodeCart.CodeCartbackend.Request.RatingRequest;
import com.CodeCart.CodeCartbackend.Service.RatingService;
import com.CodeCart.CodeCartbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private UserService userService;
    @Autowired
    private RatingService ratingServices;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRatingHandler(@RequestBody RatingRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user=userService.findUserProfileByJwt(jwt);
        Rating rating=ratingServices.createRating(req, user);
        return new ResponseEntity<>(rating, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsReviewHandler(@PathVariable Long productId){

        List<Rating> ratings=ratingServices.getProductsRating(productId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
}
