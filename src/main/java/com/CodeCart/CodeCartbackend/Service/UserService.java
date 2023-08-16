package com.CodeCart.CodeCartbackend.Service;


import com.CodeCart.CodeCartbackend.Exceptions.UserException;
import com.CodeCart.CodeCartbackend.Model.User;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

}
