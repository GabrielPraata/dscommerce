package com.prata.dscommerce.repositories;

import com.prata.dscommerce.entities.OrdemItemPK;
import com.prata.dscommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK> {
}
