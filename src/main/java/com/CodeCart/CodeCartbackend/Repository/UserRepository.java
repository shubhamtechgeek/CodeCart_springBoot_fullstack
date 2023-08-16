package com.CodeCart.CodeCartbackend.Repository;

import com.CodeCart.CodeCartbackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
