package com.example.demo.repository;

import com.example.demo.entity.ProductDetails;
import com.example.demo.entity.respon.Respon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDetailsRepo extends JpaRepository<ProductDetails, Integer> {

    @Query(value = "SELECT distinct * FROM ProductDetails \n" +
            "where productdetailid in (select productdetailid from productdetailpropertydetails\n" +
            "group by productdetailid)", nativeQuery = true)
    public List<ProductDetails> hienThiThuocTinhDoiCuoi();

    @Query(value = "SELECT distinct productdetailid FROM ProductDetails \n" +
            "where productdetailid in (select productdetailid from productdetailpropertydetails\n" +
            "group by productdetailid)", nativeQuery = true)
    public List<Integer> sanPhamDoiCuoi();
}
