package com.example.project02.service;

import com.example.project02.entity.SellProduct;
import com.example.project02.repository.SellProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class SellProductService {

    private final SellProductRepository sellProductRepository;

    public void registerProduct(SellProduct sellProduct) {
        if (sellProduct == null) {
            throw new IllegalArgumentException("물품정보가 없습니다.");
        }

        sellProductRepository.save(sellProduct);
    }

    public SellProduct findProductById(Long productId) {
        return sellProductRepository.findById(productId).orElse(null);
    }

    public void adjustStock(Long productId, Integer stockAdjustment, Date updateDate) {
        if (productId == null || stockAdjustment == null) {
            throw new IllegalArgumentException("제품 ID와 재고 조정 값은 반드시 입력되어야 합니다.");
        }

        SellProduct product = sellProductRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("지정된 ID의 물품이 없습니다.");
        }

        // Adjust stock
        product.setStockQuantity(product.getStockQuantity() + stockAdjustment);
        product.setRegistrationDate(updateDate);  // Assuming this is meant to update the registration date

        sellProductRepository.save(product);
    }
} 