package com.example.project02.converter;

import com.example.project02.entity.SellProduct;
import com.example.project02.service.SellProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class SellProductController {

    private final SellProductService sellProductService;

    @GetMapping("/api/sellproduct/register")
    public String showRegistrationForm() {
        return "sellProductRegister";  // sellProductRegister.html 뷰 반환
    }

    @PostMapping("/api/sellproduct/register")
    public String registerProduct(
            @RequestParam String productName,
            @RequestParam String productDescription,
            @RequestParam Double price,
            @RequestParam Integer stockQuantity,
            @RequestParam Date registrationDate,
            Model model) {

        SellProduct sellProduct = new SellProduct();
        sellProduct.setProductName(productName);
        sellProduct.setProductDescription(productDescription);
        sellProduct.setPrice(price);
        sellProduct.setStockQuantity(stockQuantity);
        sellProduct.setRegistrationDate(registrationDate);

        sellProductService.registerProduct(sellProduct);

        model.addAttribute("message", "물품이 성공적으로 등록되었습니다.");
        return "successPage";  // successPage.html 뷰 반환
    }

    @GetMapping("/api/sellproduct/search")
    public String searchProduct(
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) String searchQuery,
            @RequestParam(required = false) String stockStatus,  // 예: IN_STOCK, OUT_OF_STOCK 등의 값
            @RequestParam(required = false) Date predictedsaleenddate,
            Model model) {
        return "productSearchResults";
    }

    @PostMapping("/sellproduct/adjuststock")
    public String adjustStock(
            @RequestParam Long productId,
            @RequestParam Integer stockAdjustment,
            @RequestParam Date updateDate,
            Model model) {

        try {
            sellProductService.adjustStock(productId, stockAdjustment, (java.sql.Date) updateDate);
            model.addAttribute("message", "재고가 성공적으로 수정되었습니다.");
            return "successPage";  // successPage.html 뷰 반환
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "errorPage";  // errorPage.html 뷰 반환

        }
    }
}