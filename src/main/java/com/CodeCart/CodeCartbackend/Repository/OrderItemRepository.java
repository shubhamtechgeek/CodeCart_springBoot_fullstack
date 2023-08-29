package com.CodeCart.CodeCartbackend.Repository;

import com.CodeCart.CodeCartbackend.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
