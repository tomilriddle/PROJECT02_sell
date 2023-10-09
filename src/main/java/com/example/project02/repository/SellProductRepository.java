package com.example.project02.repository;

import com.example.project02.entity.SellProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellProductRepository extends JpaRepository<SellProduct, Long> {
}
