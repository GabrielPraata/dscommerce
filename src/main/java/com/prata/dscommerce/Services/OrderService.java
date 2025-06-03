package com.prata.dscommerce.Services;

import com.prata.dscommerce.Services.exceptios.ResourceNotFoundException;
import com.prata.dscommerce.dto.OrderDTO;
import com.prata.dscommerce.dto.ProductDTO;
import com.prata.dscommerce.entities.Order;
import com.prata.dscommerce.entities.Product;
import com.prata.dscommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
