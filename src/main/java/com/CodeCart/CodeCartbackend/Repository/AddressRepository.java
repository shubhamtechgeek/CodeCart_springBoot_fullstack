package com.CodeCart.CodeCartbackend.Repository;

import com.CodeCart.CodeCartbackend.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
