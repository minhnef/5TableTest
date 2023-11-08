package com.example.demo.controller;

import com.example.demo.service.ProductDetailsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "apiproductdetail")
public class ProductDetailsCTL {
    @Autowired
    ProductDetailsSer productDetailsSer;
    //1
    @PutMapping(value = "sellProduct")
    public ResponseEntity<?> ban(int productdetailid, int quantity){
        return ResponseEntity.ok(productDetailsSer.shopping(productdetailid, quantity));
    }

    //2
    @PutMapping(value = "updateQuantity")
    public ResponseEntity<?>capnhat(int productdetailid, int quantity){
        return ResponseEntity.ok(productDetailsSer.capNhat(productdetailid, quantity));
    }

    //3
    @GetMapping(value = "getProductDetails")
    public ResponseEntity<?> hienThiDoiCuoi(){
        return ResponseEntity.ok(productDetailsSer.hienThiDoiCuoiCung());
    }
}
