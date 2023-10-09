package com.example.project02.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class SellProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private Double price;
    private Integer stockQuantity;
    private Date registrationDate;

    public void setProductName(String productName) {
    }

    public void setProductDescription(String productDescription) {
    }

    public void setPrice(Double price) {
    }

    public void setStockQuantity(Integer stockQuantity) {
    }

    public void setRegistrationDate(Date registrationDate) {
    }

    public Integer getStockQuantity() {
        return stockQuantity;

    }
}
